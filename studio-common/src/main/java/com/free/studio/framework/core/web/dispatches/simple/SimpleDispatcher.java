package com.free.studio.framework.core.web.dispatches.simple;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import com.alibaba.fastjson.JSON;
import com.free.studio.framework.core.Environment;
import com.free.studio.framework.core.exception.FrameworkException;
import com.free.studio.framework.core.web.WebConfig;
import com.free.studio.framework.core.web.WebDispatcher;

/**
 * @Title: SimpleDispatcher.java
 * @Package com.free.studio.framework.core.web.dispatches.simple
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:31:55
 * @version V1.0
 */
public class SimpleDispatcher implements WebDispatcher {
	protected WebConfig webConfig = null;
	protected Environment environment = null;
	private String extension = null;
	private int extensionLength = 0;

	public void init(WebConfig config) throws ServletException {
		this.webConfig = config;
		this.environment = ((Environment) this.webConfig.getAppContext().getBean(Environment.class));
		this.extension = this.environment.getRequestExtension();
		this.extensionLength = this.extension.length();
	}

	public void destroy() {
		this.webConfig = null;
		this.environment = null;
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		ActionContext context = new ActionContext(request, response);
		String uri = request.getRequestURI();
		RequestAction action = resolveAction(uri);
		ActionResult result = action.handle(context);
		if ((result instanceof ActionResult.ForwardResult)) {
			request.getRequestDispatcher(((ActionResult.ForwardResult) result).getUrl()).forward(request, response);
		} else if ((result instanceof ActionResult.RedirectResult)) {
			response.sendRedirect(((ActionResult.RedirectResult) result).getUrl());
		} else if ((result instanceof ActionResult.JSONResult)) {
			String returnMsg = JSON.toJSONString(result);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(returnMsg);
			response.flushBuffer();
		}
	}

	private RequestAction resolveAction(String uri) {
		int begin = uri.lastIndexOf("/");
		int end = uri.length() - this.extensionLength;
		String name = uri.substring(begin, end);
		try {
			return (RequestAction) this.webConfig.getAppContext().getBean(name, RequestAction.class);
		} catch (NoSuchBeanDefinitionException e) {
			throw new FrameworkException("action[" + name + "] not found.the request uri is " + uri);
		}
	}
}
