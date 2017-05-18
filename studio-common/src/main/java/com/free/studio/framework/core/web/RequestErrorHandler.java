package com.free.studio.framework.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: RequestErrorHandler.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:26:06
 * @version V1.0
 */
public interface RequestErrorHandler {
	public abstract void handle(Throwable paramThrowable, HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse);
}
