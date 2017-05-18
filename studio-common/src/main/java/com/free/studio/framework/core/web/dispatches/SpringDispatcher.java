package com.free.studio.framework.core.web.dispatches;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free.studio.framework.core.web.WebConfig;
import com.free.studio.framework.core.web.WebDispatcher;
import com.free.studio.framework.core.web.servlet.DispatcherServlet;

/**
 * @Title: SpringDispatcher.java
 * @Package com.free.studio.framework.core.web.dispatches
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:30:02
 * @version V1.0
 */
public class SpringDispatcher implements WebDispatcher {
	private DispatcherServlet dispatcherServlet = null;

	public void init(WebConfig config) throws ServletException {
		this.dispatcherServlet = new DispatcherServlet(config.getAppContext());
		this.dispatcherServlet.init(config.getServletConfig());
	}

	public void destroy() {
		this.dispatcherServlet.destroy();
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		this.dispatcherServlet.service(request, response);
	}
}
