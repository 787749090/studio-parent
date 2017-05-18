package com.free.studio.framework.core.web.interceptors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: AbstractWebInterceptor.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:32:59
 * @version V1.0
 */
public class AbstractWebInterceptor implements GlobalWebInterceptor {
	public void initialize() {
	}

	public void intercept(HttpServletRequest request, HttpServletResponse response, InterceptorChain chain)
			throws IOException, ServletException {
	}

	public void release() {
	}
}
