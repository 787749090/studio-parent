package com.free.studio.framework.components.session;

import java.util.UUID;

import javax.servlet.http.Cookie;

import com.free.studio.framework.components.session.cache.SessionCache;
import com.free.studio.framework.components.session.web.CookieUtil;
import com.free.studio.framework.core.security.UnLoginException;
import com.free.studio.framework.core.security.UserContext;
import com.free.studio.framework.core.security.UserContextFactory;
import com.free.studio.framework.core.web.HttpRequestHolder;
import com.free.studio.framework.core.web.HttpResponseHolder;

/**
 * @Title: CacheUserContextFactory.java
 * @Package com.free.studio.framework.components.session
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:53:16
 * @version V1.0
 */
public class CacheUserContextFactory implements UserContextFactory {
	public static final String SESSION_ID = "C_SID";
	private static final String REQ_ATTR_SESSION_ID = "__request.session_id";
	private SessionCache sessionCache;

	public UserContext getLoggedInUser() throws UnLoginException {
		String sid = getSessionID();
		UserContext user = null;
		if (sid != null) {
			user = this.sessionCache.getSessionObject(sid);
		}
		if (user == null) {
			throw new UnLoginException();
		}
		return user;
	}

	public boolean isLoggedIn() {
		String sid = getSessionID();
		if (sid != null) {
			return this.sessionCache.getSessionObject(sid) != null;
		}
		return false;
	}

	public void login(UserContext user) {
		String sid = getSessionID();
		if (sid == null) {
			sid = createSessionID();

			int expiry = this.sessionCache.getTimeToIdleSeconds();

			CookieUtil.addCookie(HttpResponseHolder.getResponse(), "C_SID", sid, "/");

			HttpRequestHolder.getRequest().setAttribute("__request.session_id", sid);
		}
		this.sessionCache.setSessionObject(sid, user);
	}

	public void logout() {
		String sid = getSessionID();
		if (sid != null) {
			this.sessionCache.setSessionObject(sid, null);
		}
	}

	private String getSessionID() {
		String sid = (String) HttpRequestHolder.getRequest().getAttribute("__request.session_id");
		if (sid == null) {
			Cookie cookie = CookieUtil.getCookie(HttpRequestHolder.getRequest(), "C_SID");
			if (cookie != null) {
				sid = cookie.getValue();
			}
		}
		return sid;
	}

	private String createSessionID() {
		return UUID.randomUUID().toString();
	}

	public SessionCache getSessionCache() {
		return this.sessionCache;
	}

	public void setSessionCache(SessionCache sessionCache) {
		this.sessionCache = sessionCache;
	}
}
