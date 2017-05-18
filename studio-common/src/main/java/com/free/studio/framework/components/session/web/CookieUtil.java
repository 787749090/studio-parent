package com.free.studio.framework.components.session.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: CookieUtil.java
 * @Package com.free.studio.framework.components.session.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午3:00:00
 * @version V1.0
 */
public class CookieUtil {
	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		if ((cookies != null) && (name != null)) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				if (name.equals(cookie.getName())) {
					return cookie;
				}
			}
		}
		return null;
	}

	public static void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		response.addCookie(cookie);
	}

	public static void addCookie(HttpServletResponse response, String name, String value, String path) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);
		response.addCookie(cookie);
	}

	public static void addCookie(HttpServletResponse response, String name, String value, String path, int expiry) {
		Cookie cookie = new Cookie(name, value);
		cookie.setPath(path);
		cookie.setMaxAge(expiry);
		response.addCookie(cookie);
	}
}
