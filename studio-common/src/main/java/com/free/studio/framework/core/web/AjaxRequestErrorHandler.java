package com.free.studio.framework.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: AjaxRequestErrorHandler.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:24:42
 * @version V1.0
 */
public class AjaxRequestErrorHandler implements RequestErrorHandler {
	public void handle(Throwable error, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.reset();
			response.setCharacterEncoding("UTF-8");
			response.setStatus(500);
			response.getWriter().write("{status:'error'}");
		} catch (Exception er) {
			response.setStatus(500);
		}
	}
}
