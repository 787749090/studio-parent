package com.free.studio.framework.core.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

/**
 * @Title: ServletHandlerInvoker.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:37:54
 * @version V1.0
 */
public class ServletHandlerInvoker {
	private static String ignoreFilesExtensionPattern = "(^.*\\.jpg$)|(^.*\\.png$)|(^.*\\.gif$)|(^.*\\.ico$)";

	public boolean invokeHandlers(ApplicationContext context, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, ServletHandler> handlers = context.getBeansOfType(ServletHandler.class);
		for (Iterator<ServletHandler> iter = handlers.values().iterator(); iter.hasNext();) {
			ServletHandler handler = (ServletHandler) iter.next();
			if (handler.isQualified(request)) {
				return handler.handle(request, response);
			}
		}
		return true;
	}

	public boolean isNecessaryPreprocess(HttpServletRequest request) {
		String uri = request.getRequestURI().toLowerCase();
		return !uri.matches(ignoreFilesExtensionPattern);
	}
}
