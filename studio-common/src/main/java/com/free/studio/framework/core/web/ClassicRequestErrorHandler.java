package com.free.studio.framework.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free.studio.framework.core.exception.ExceptionHolder;
import com.free.studio.framework.core.security.UnLoginException;

/**
 * @Title: ClassicRequestErrorHandler.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:25:00
 * @version V1.0
 */
public class ClassicRequestErrorHandler implements RequestErrorHandler {
	public void handle(Throwable error, HttpServletRequest request, HttpServletResponse response) {
		ExceptionHolder.addException(error);
		try {
			if ((error instanceof UnLoginException)) {
				request.getRequestDispatcher("/jsp/error/login_error.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/jsp/error/system_error.jsp").forward(request, response);
			}
		} catch (Exception er) {
			response.setStatus(500);
		}
	}
}
