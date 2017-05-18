package com.free.studio.framework.core.web.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: FilterWebInterceptor.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:33:52
 * @version V1.0
 */
public abstract class FilterWebInterceptor extends AbstractWebInterceptor {
	protected Filter filter = null;

	protected Filter getFilter() {
		if (this.filter == null) {
			this.filter = createFilter();
		}
		return this.filter;
	}

	protected abstract Filter createFilter();

	public void intercept(HttpServletRequest request, HttpServletResponse response, InterceptorChain chain)
			throws IOException, ServletException {
		getFilter().doFilter(request, response, new FilterChainAdapter(chain));
	}
}
