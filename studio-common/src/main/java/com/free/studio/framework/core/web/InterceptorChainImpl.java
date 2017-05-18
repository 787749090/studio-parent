package com.free.studio.framework.core.web;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free.studio.framework.core.web.interceptors.GlobalWebInterceptor;
import com.free.studio.framework.core.web.interceptors.InterceptorChain;

/**
 * @Title: InterceptorChainImpl.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:25:47
 * @version V1.0
 */
public class InterceptorChainImpl implements InterceptorChain {
	private Iterator<GlobalWebInterceptor> interceptors = null;
	private FilterChain filterChain = null;

	public InterceptorChainImpl(List<GlobalWebInterceptor> interceptors, FilterChain filterChain) {
		this.interceptors = interceptors.iterator();
		this.filterChain = filterChain;
	}

	public void intercept(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (this.interceptors.hasNext()) {
			((GlobalWebInterceptor) this.interceptors.next()).intercept(request, response, this);
		}
	}

	public FilterChain getFilterChain() {
		return this.filterChain;
	}
}
