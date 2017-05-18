package com.free.studio.framework.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.NamedThreadLocal;

/**
 * @Title: HttpRequestHolder.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:25:16
 * @version V1.0
 */
public class HttpRequestHolder {
	private static NamedThreadLocal<HttpServletRequest> registry = new NamedThreadLocal("http-request");

	public static void register(HttpServletRequest request) {
		registry.set(request);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) registry.get();
	}

	public static void release() {
		registry.remove();
	}
}
