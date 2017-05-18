package com.free.studio.framework.core.web.interceptors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: ServletWebInterceptor.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:35:25
 * @version V1.0
 */
public abstract class ServletWebInterceptor extends AbstractWebInterceptor {
	protected HttpServlet httpServlet = null;

	protected HttpServlet getHttpServlet() {
		if (this.httpServlet == null) {
			this.httpServlet = createHttpServlet();
		}
		return this.httpServlet;
	}

	protected abstract HttpServlet createHttpServlet();

	protected void doService(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		getHttpServlet().service(request, response);
	}

	public void intercept(HttpServletRequest request, HttpServletResponse response, InterceptorChain chain)
			throws IOException, ServletException {
		doService(request, response);
	}
}
