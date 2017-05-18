package com.free.studio.framework.core.web.dispatches;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.web.WebConfig;
import com.free.studio.framework.core.web.WebDispatcher;

/**
 * @Title: NoneDispatcher.java
 * @Package com.free.studio.framework.core.web.dispatches
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:29:02
 * @version V1.0
 */
public class NoneDispatcher implements WebDispatcher {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void init(WebConfig config) throws ServletException {
	}

	public void destroy() {
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		filterChain.doFilter(request, response);
	}
}
