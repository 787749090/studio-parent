package com.free.studio.framework.core.web;

import java.util.Enumeration;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Title: WebConfig.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:26:47
 * @version V1.0
 */
public class WebConfig {
	private FilterConfig config = null;
	private WebApplicationContext applicationContext = null;

	public WebConfig(WebApplicationContext applicationContext, FilterConfig config) {
		this.applicationContext = applicationContext;
		this.config = config;
	}

	public WebApplicationContext getAppContext() {
		return this.applicationContext;
	}

	public FilterConfig getFilterConfig() {
		return this.config;
	}

	public ServletConfig getServletConfig() {
		return new ServletConfig() {
			public String getServletName() {
				return WebConfig.this.applicationContext.getId() + "_servlet";
			}

			public ServletContext getServletContext() {
				return WebConfig.this.config.getServletContext();
			}

			public Enumeration getInitParameterNames() {
				return WebConfig.this.config.getInitParameterNames();
			}

			public String getInitParameter(String name) {
				return WebConfig.this.config.getInitParameter(name);
			}
		};
	}
}
