package com.free.studio.framework.core.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;

/**
 * @Title: HttpResponseHolder.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:25:32
 * @version V1.0
 */
public class HttpResponseHolder {
	private static NamedThreadLocal<HttpServletResponse> registry = new NamedThreadLocal("http-response");

	public static void register(HttpServletResponse response) {
		registry.set(response);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) registry.get();
	}

	public static void release() {
		registry.remove();
	}
}
