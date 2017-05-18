package com.free.studio.framework.core.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

import com.free.studio.framework.core.context.ContextHolder;
import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.context.exception.ContextNotFoundException;
import com.free.studio.framework.core.exception.ExceptionHolder;
import com.free.studio.framework.core.i18n.LocaleHolder;
import com.free.studio.framework.core.utils.ContextUtils;
import com.free.studio.framework.core.web.HttpRequestHolder;
import com.free.studio.framework.core.web.HttpResponseHolder;

/**
 * @Title: SpringMVCDispatcher.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:38:07
 * @version V1.0
 */
public class SpringMVCDispatcher extends HttpServlet {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final String DEFAULT_ENCODING = "UTF-8";
	private Map<String, DispatcherServlet> dispatchers = new HashMap();
	private DispatcherServlet rootServlet = null;
	private ServletHandlerInvoker handlerInvoker = new ServletHandlerInvoker();

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		this.rootServlet = new DispatcherServlet((WebApplicationContext) ContextManager.getRootContext());
		this.rootServlet.init(config);

		this.dispatchers.put("root", this.rootServlet);
		Set<String> names = ContextManager.getModuleNames();
		for (String name : names) {
			ApplicationContext module = ContextManager.getModuleContext(name);
			DispatcherServlet servlet = new DispatcherServlet((WebApplicationContext) module);
			servlet.init(config);
			this.dispatchers.put(name, servlet);
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpRequestHolder.register(request);
		HttpResponseHolder.register(response);
		try {
			ContextHolder.register(request);
		} catch (ContextNotFoundException e) {
			this.logger.info("context not found.url:{}", request.getRequestURI());
		}
		this.logger.debug("url:{}", request.getRequestURI());
		try {
			ApplicationContext context = ContextUtils.getContextWithoutException(request);
			if (context != null) {
				if (this.handlerInvoker.isNecessaryPreprocess(request) == true) {
					setLocale(request, context);
					if (!this.handlerInvoker.invokeHandlers(context, request, response)) {
						return;
					}
				}
				DispatcherServlet servlet = (DispatcherServlet) this.dispatchers.get(context.getId());
				servlet.service(request, response);
			} else {
				this.rootServlet.service(request, response);
			}
		} catch (Exception e) {
			this.logger.error("uri:" + request.getRequestURI() + ";error msg:" + e.getMessage(), e);

			ExceptionHolder.addException(e);
			request.getRequestDispatcher("/jsp/error/Error.jsp").forward(request, response);
		} finally {
			ExceptionHolder.clearUp();
			ContextHolder.release();
			HttpRequestHolder.release();
			HttpResponseHolder.release();
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

	public void destroy() {
		for (Iterator iterator = this.dispatchers.values().iterator(); iterator.hasNext();) {
			try {
				DispatcherServlet servlet = (DispatcherServlet) iterator.next();
				servlet.destroy();
			} catch (Exception e) {
			}
		}
	}
}
