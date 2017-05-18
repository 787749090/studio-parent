package com.free.studio.framework.core.web.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: DispatcherServlet.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:36:24
 * @version V1.0
 */
@Deprecated
public class DispatcherServlet extends org.springframework.web.servlet.DispatcherServlet {
	public DispatcherServlet() {
	}

	public DispatcherServlet(WebApplicationContext webApplicationContext) {
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
}
