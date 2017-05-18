package com.free.studio.framework.core.web.interceptors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: FilterChainAdapter.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:33:30
 * @version V1.0
 */
public class FilterChainAdapter implements FilterChain {
	private InterceptorChain chain = null;

	public FilterChainAdapter(InterceptorChain chain) {
		this.chain = chain;
	}

	public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		this.chain.intercept((HttpServletRequest) request, (HttpServletResponse) response);
	}
}
