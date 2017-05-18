package com.free.studio.framework.core.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.ognl.MethodAccessor;
import org.apache.ibatis.ognl.OgnlRuntime;
import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

import com.free.studio.framework.core.context.ContextHolder;
import com.free.studio.framework.core.context.exception.ContextNotFoundException;
import com.free.studio.framework.core.exception.ExceptionHolder;
import com.free.studio.framework.core.i18n.LocaleHolder;
import com.free.studio.framework.core.utils.ContextUtils;
import com.free.studio.framework.core.web.HttpRequestHolder;
import com.free.studio.framework.core.web.HttpResponseHolder;

/**
 * @Title: MVCDispatcher.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:36:49
 * @version V1.0
 */
public class MVCDispatcher extends StrutsPrepareAndExecuteFilter {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static final String DEFAULT_ENCODING = "UTF-8";
	private static String ignoreFilesExtensionPattern = "(^.*\\.jpg$)|(^.*\\.png$)|(^.*\\.gif$)|(^.*\\.ico$)";

	public void init(FilterConfig filterConfig) throws ServletException {
		super.init(filterConfig);
		MethodAccessor deny = new SecurityMethodAccessor();

		OgnlRuntime.setMethodAccessor(Runtime.class, deny);
		OgnlRuntime.setMethodAccessor(ProcessBuilder.class, deny);
		OgnlRuntime.setMethodAccessor(OgnlRuntime.class, deny);
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		request.setCharacterEncoding("UTF-8");

		HttpRequestHolder.register(request);
		HttpResponseHolder.register(response);
		try {
			ContextHolder.register(request);
		} catch (ContextNotFoundException e) {
			this.logger.info("context not found.url:{}", request.getRequestURI());
		}
		try {
			if (isNecessaryPreprocess(request) == true) {
				try {
					ApplicationContext context = ContextUtils.getContext(request);
					if (context != null) {
						setLocale(request, context);
						if (!invokeHandlers(context, request, response)) {
							return;
						}
					}
				} catch (ContextNotFoundException e) {
				}
			}
			super.doFilter(req, res, chain);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);

			ExceptionHolder.addException(e);
			String path = request.getContextPath();
			request.getRequestDispatcher("/jsp/error/Error.jsp").forward(request, response);
		} finally {
			ExceptionHolder.clearUp();
			ContextHolder.release();
			HttpRequestHolder.release();
			HttpResponseHolder.release();
		}
	}

	private boolean invokeHandlers(ApplicationContext context, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, ServletHandler> handlers = context.getBeansOfType(ServletHandler.class);
		for (Iterator iter = handlers.values().iterator(); iter.hasNext();) {
			ServletHandler handler = (ServletHandler) iter.next();
			if (handler.isQualified(request)) {
				return handler.handle(request, response);
			}
		}
		return true;
	}

	private void setLocale(HttpServletRequest request, ApplicationContext context) {
		try {
			LocaleResolver resolver = (LocaleResolver) context.getBean(LocaleResolver.class);
			Locale locale = resolver.resolveLocale(request);
			LocaleHolder.setLocale(locale);
		} catch (BeansException e) {
		}
	}

	private boolean isNecessaryPreprocess(HttpServletRequest request) {
		String uri = request.getRequestURI().toLowerCase();
		return !uri.matches(ignoreFilesExtensionPattern);
	}
}
