package com.free.studio.framework.core.web.interceptors;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Title: InterceptorChain.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:34:31
 * @version V1.0
 */
public interface InterceptorChain {
	public abstract void intercept(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse) throws IOException, ServletException;
}
