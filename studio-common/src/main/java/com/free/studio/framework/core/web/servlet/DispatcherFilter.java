package com.free.studio.framework.core.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: DispatcherFilter.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:36:01
 * @version V1.0
 */
public class DispatcherFilter extends DispatcherServlet implements Filter {
	public DispatcherFilter() {
	}

	public DispatcherFilter(WebApplicationContext webApplicationContext) {
		super(webApplicationContext);
	}

	protected void initStrategies(ApplicationContext context) {
		super.initStrategies(context);
	}

	protected WebApplicationContext createWebApplicationContext(ApplicationContext parent) {
		XmlWebApplicationContext wac = new XmlWebApplicationContext();

		String module = getModuleName();

		parent = getContext(module);

		String location = "/WEB-INF/" + module + "/*-servlet.xml";
		wac.setParent(parent);
		wac.setConfigLocation(location);
		configureAndRefreshWebApplicationContext(wac);
		return wac;
	}

	protected String getModuleName() {
		String module = getNamespace();
		if ((module == null) || (module.length() < 1)) {
			throw new FrameworkException("the namespace of DispatcherServlet is required.");
		}
		return "root".equals(module) ? "" : module;
	}

	private ApplicationContext getContext(String module) {
		ApplicationContext ctx;
		if (module.length() < 1) {
			ctx = ContextManager.getRootContext();
		} else {
			ctx = ContextManager.getModuleContext(module);
		}
		return ctx;
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
