package com.free.studio.framework.core.security;

/**
 * @Title: UserContextFactory.java
 * @Package com.free.studio.framework.core.security
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:16:43
 * @version V1.0
 */
public interface UserContextFactory {
	public abstract boolean isLoggedIn();

	public abstract void login(UserContext paramUserContext);

	public abstract UserContext getLoggedInUser() throws UnLoginException;

	public abstract void logout();
}
