package com.free.studio.framework.core.web.dispatches;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.web.WebConfig;
import com.free.studio.framework.core.web.WebDispatcher;

/**
 * @Title: HaltDispatcher.java
 * @Package com.free.studio.framework.core.web.dispatches
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:28:42
 * @version V1.0
 */
public class HaltDispatcher implements WebDispatcher {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void init(WebConfig config) throws ServletException {
	}

	public void destroy() {
	}

	public void dispatch(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String sid = session == null ? "null" : session.getId();
		String reqUrl = request.getRequestURL().toString();
		StringBuilder buf = new StringBuilder();
		buf.append("'servletProvider' configuration in Environment is  missing. ");
		buf.append(" sessionid:").append(sid).append(";");
		buf.append(" request url:").append(reqUrl);
		String str = buf.toString();
		this.logger.info(str);
	}
}
