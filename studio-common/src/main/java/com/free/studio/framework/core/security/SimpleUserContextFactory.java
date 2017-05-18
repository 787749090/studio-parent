package com.free.studio.framework.core.security;

import com.free.studio.framework.core.web.HttpRequestHolder;

/**
 * @Title: SimpleUserContextFactory.java
 * @Package com.free.studio.framework.core.security
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:15:27
 * @version V1.0
 */
public class SimpleUserContextFactory implements UserContextFactory {
	public static final String LOGGEDIN_USER_SESSION_KEY = "loggedin.user.session.id";

	public UserContext getLoggedInUser() throws UnLoginException {
		UserContext user = (UserContext) getSessionAttribute("loggedin.user.session.id");
		if (user == null) {
			throw new UnLoginException();
		}
		return user;
	}

	public boolean isLoggedIn() {
		return getSessionAttribute("loggedin.user.session.id") != null;
	}

	public void login(UserContext user) {
		setSessionAttribute("loggedin.user.session.id", user);
	}

	protected void setSessionAttribute(String key, Object value) {
		HttpRequestHolder.getRequest().getSession().setAttribute(key, value);
	}

	protected Object getSessionAttribute(String key) {
		return HttpRequestHolder.getRequest().getSession().getAttribute(key);
	}

	public void logout() {
		setSessionAttribute("loggedin.user.session.id", null);
	}
}
