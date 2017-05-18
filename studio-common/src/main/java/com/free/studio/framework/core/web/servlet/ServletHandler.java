package com.free.studio.framework.core.web.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: ServletHandler.java
 * @Package com.free.studio.framework.core.web.servlet
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:37:26
 * @version V1.0
 */
public interface ServletHandler {
	public abstract void init(ServletContext paramServletContext);

	public abstract boolean handle(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws ServletException, IOException;

	public abstract boolean isQualified(HttpServletRequest paramHttpServletRequest);

	public abstract void destory();
}
