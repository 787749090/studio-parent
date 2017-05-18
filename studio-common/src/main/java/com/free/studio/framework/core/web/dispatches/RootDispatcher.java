package com.free.studio.framework.core.web.dispatches;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.web.dispatches.simple.SimpleDispatcher;

/**
 * @Title: RootDispatcher.java
 * @Package com.free.studio.framework.core.web.dispatches
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:29:22
 * @version V1.0
 */
public class RootDispatcher extends SimpleDispatcher {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		String reqUrl = request.getRequestURL().toString();
		HttpSession session = request.getSession();
		String sid = session == null ? "null" : session.getId();
		this.logger.debug("Root Module. sessionid:{},request url:{}", sid, reqUrl);
		super.dispatch(request, response, filterChain);
	}
}
