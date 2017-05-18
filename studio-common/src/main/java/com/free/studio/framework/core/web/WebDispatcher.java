package com.free.studio.framework.core.web;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: WebDispatcher.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:27:05
 * @version V1.0
 */
public interface WebDispatcher {
	public abstract void init(WebConfig paramWebConfig) throws ServletException, ServletException;

	public abstract void destroy();

	public abstract void dispatch(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse, FilterChain paramFilterChain)
					throws IOException, ServletException;
}
