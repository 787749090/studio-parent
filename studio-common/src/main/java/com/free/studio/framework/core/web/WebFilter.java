package com.free.studio.framework.core.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

import com.free.studio.framework.core.Environment;
import com.free.studio.framework.core.context.ContextHolder;
import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.exception.ExceptionHolder;
import com.free.studio.framework.core.i18n.LocaleHolder;
import com.free.studio.framework.core.utils.ContextUtils;
import com.free.studio.framework.core.utils.EmptyUtils;
import com.free.studio.framework.core.web.dispatches.NoneDispatcher;
import com.free.studio.framework.core.web.dispatches.RootDispatcher;
import com.free.studio.framework.core.web.interceptors.AbstractWebInterceptor;
import com.free.studio.framework.core.web.interceptors.GlobalWebInterceptor;
import com.free.studio.framework.core.web.interceptors.InterceptorChain;
import com.free.studio.framework.core.web.interceptors.InterceptorFactory;
import com.free.studio.framework.core.web.servlet.ServletHandlerInvoker;

/**
 * @Title: WebFilter.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:27:28
 * @version V1.0
 */
public class WebFilter extends AbstractWebInterceptor implements Filter {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final String DEFAULT_ENCODING = "UTF-8";
	private Map<String, WebDispatcher> dispatchers = new HashMap();
	private Map<String, Environment> environmentHolder = new HashMap();
	private ServletHandlerInvoker handlerInvoker = new ServletHandlerInvoker();
	private WebDispatcher defaultDispatcher = new NoneDispatcher();
	private InterceptorFactory interceptorFactory = new InterceptorFactory();
	private ThreadLocal<Boolean> ignoreFilterHodler = new ThreadLocal();

	public void init(FilterConfig filterConfig) throws ServletException {
		WebConfig rootConfig = new WebConfig((WebApplicationContext) ContextManager.getRootContext(), filterConfig);
		WebDispatcher rootDispatcher = new RootDispatcher();
		rootDispatcher.init(rootConfig);

		this.dispatchers.put("root", rootDispatcher);
		this.environmentHolder.put("root", rootConfig.getAppContext().getBean(Environment.class));
		Set<String> names = ContextManager.getModuleNames();
		for (String name : names) {
			ApplicationContext module = ContextManager.getModuleContext(name);
			this.environmentHolder.put(name, module.getBean(Environment.class));
			WebConfig config = new WebConfig((WebApplicationContext) module, filterConfig);
			WebDispatcher dispatcher = buildDispatcher(module);
			dispatcher.init(config);
			this.dispatchers.put(name, dispatcher);
		}
		this.interceptorFactory.loadInterceptors();
	}

	private WebDispatcher buildDispatcher(ApplicationContext module) {
		Environment env = (Environment) module.getBean(Environment.class);
		try {
			if (EmptyUtils.isEmpty(env.getServletProvider())) {
				this.logger.warn(
						"Module {}:'servletProvider' configuration in Environment is  missing.'NoneDispather' instead.",
						module.getId());
				return new NoneDispatcher();
			}
			Class clazz = ClassUtils.forName(env.getServletProvider(), module.getClassLoader());
			if (WebDispatcher.class.isAssignableFrom(clazz)) {
				return (WebDispatcher) clazz.newInstance();
			}
			throw new RuntimeException(
					"ServletProvider Error.ServletProvider is not WebDispatcher:" + env.getServletProvider());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public void destroy() {
		for (Iterator<WebDispatcher> iterator = this.dispatchers.values().iterator(); iterator.hasNext();) {
			try {
				WebDispatcher dispatcher = (WebDispatcher) iterator.next();
				dispatcher.destroy();
			} catch (Exception e) {
			}
		}
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		request.setCharacterEncoding("UTF-8");

		HttpRequestHolder.register(request);
		HttpResponseHolder.register(response);
		this.logger.debug("uri:{}", request.getRequestURI());
		RequestErrorHandler requestErrorHandler = null;
		try {
			requestErrorHandler = determineErrorHandler(request);

			List<GlobalWebInterceptor> interceptors = this.interceptorFactory.matchInterceptors(request);
			interceptors.add(this);
			new InterceptorChainImpl(interceptors, filterChain).intercept(request, response);
		} catch (Exception e) {
			if (this.ignoreFilterHodler.get() == Boolean.TRUE) {
				response.reset();
				response.setStatus(500);
			} else {
				this.ignoreFilterHodler.set(Boolean.TRUE);
				this.logger.error("uri:" + request.getRequestURI() + ";error msg:" + e.getMessage(), e);
				requestErrorHandler.handle(e, request, response);
			}
		} finally {
			ExceptionHolder.clearUp();
			ContextHolder.release();
			HttpRequestHolder.release();
			HttpResponseHolder.release();
			this.ignoreFilterHodler.remove();
		}
	}

	public void intercept(HttpServletRequest request, HttpServletResponse response, InterceptorChain chain)
			throws IOException, ServletException {
		dispatchModule(request, response, ((InterceptorChainImpl) chain).getFilterChain());
	}

	protected void dispatchModule(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		ApplicationContext context = ContextUtils.getContextWithoutException(request);
		if (context != null) {
			ContextHolder.register(context);
			if (this.handlerInvoker.isNecessaryPreprocess(request) == true) {
				setLocale(request, context);
				if (!this.handlerInvoker.invokeHandlers(context, request, response)) {
					return;
				}
			}
			Environment env = (Environment) this.environmentHolder.get(context.getId());
			String uri = request.getRequestURI();
			if (uri.endsWith(env.getRequestExtension())) {
				WebDispatcher servlet = (WebDispatcher) this.dispatchers.get(context.getId());
				servlet.dispatch(request, response, filterChain);
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			this.defaultDispatcher.dispatch(request, response, filterChain);
		}
	}

	private void setLocale(HttpServletRequest request, ApplicationContext context) {
		try {
			LocaleResolver resolver = (LocaleResolver) context.getBean(LocaleResolver.class);
			Locale locale = resolver.resolveLocale(request);
			LocaleHolder.setLocale(locale);
		} catch (BeansException e) {
		}
	}

	private RequestErrorHandler determineErrorHandler(HttpServletRequest request) {
		String xRequestwWith = request.getHeader("x-requested-with");
		xRequestwWith = xRequestwWith == null ? "" : xRequestwWith;
		if ("XMLHttpRequest".equalsIgnoreCase(xRequestwWith)) {
			return new AjaxRequestErrorHandler();
		}
		return new ClassicRequestErrorHandler();
	}
}
