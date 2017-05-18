package com.free.studio.framework.components.session.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free.studio.framework.core.security.UserContextFactory;
import com.free.studio.framework.core.web.servlet.ServletHandler;

/**
 * @Title: SessionServletHandler.java
 * @Package com.free.studio.framework.components.session.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午3:00:16
 * @version V1.0
 */
public class SessionServletHandler implements ServletHandler {
	protected static final String DEFAULT_URL_PATTERN = ".+\\.shtml$";
	protected String urlPattern = ".+\\.shtml$";
	protected String[] escapeURLs = null;
	protected Map escapeURLsMap = null;
	private UserContextFactory userContextFactory;

	public void destory() {
	}

	public boolean handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (this.userContextFactory.isLoggedIn()) {
			return true;
		}
		throw new RuntimeException("unlogin");
	}

	public void init(ServletContext context) {
		if (this.escapeURLs != null) {
			this.escapeURLsMap = new HashMap();
			for (int i = 0; i < this.escapeURLs.length; i++) {
				this.escapeURLsMap.put(this.escapeURLs[i], Boolean.TRUE);
			}
		}
	}

	public boolean isQualified(HttpServletRequest request) {
		String uri = request.getRequestURI();

		uri = uri.replace(request.getContextPath(), "");
		if (this.escapeURLsMap != null) {
			if (this.escapeURLsMap.get(uri) == Boolean.TRUE) {
				return false;
			}
		}
		return uri.matches(this.urlPattern);
	}

	public String getUrlPattern() {
		return this.urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}

	public String[] getEscapeURLs() {
		return this.escapeURLs;
	}

	public void setEscapeURLs(String[] escapeURLs) {
		this.escapeURLs = escapeURLs;
	}

	public UserContextFactory getUserContextFactory() {
		return this.userContextFactory;
	}

	public void setUserContextFactory(UserContextFactory userContextFactory) {
		this.userContextFactory = userContextFactory;
	}
}
