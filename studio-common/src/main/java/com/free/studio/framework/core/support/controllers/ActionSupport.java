package com.free.studio.framework.core.support.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.free.studio.framework.core.exception.FrameworkException;
import com.free.studio.framework.core.security.UnLoginException;
import com.free.studio.framework.core.security.UserContext;
import com.free.studio.framework.core.security.UserContextFactory;
import com.free.studio.framework.core.support.AbstractSupport;
import com.free.studio.framework.core.support.model.Recordable;

/**
 * @Title: ActionSupport.java
 * @Package com.free.studio.framework.core.support.controllers
 * @Description: TODO	
 * @author yewp
 * @date 2017年5月8日 下午5:47:29
 * @version V1.0
 */
public class ActionSupport extends AbstractSupport {

	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	public static final String NONE = "none";
	public static final String ERROR = "error";
	public static final String INPUT = "input";
	public static final String LOGIN = "login";
	@Autowired
	protected UserContextFactory userContextFactory;

	@Deprecated
	protected void setSessionAttribute(String key, Object value) {
		throw new FrameworkException("prohibit operation");
	}

	@Deprecated
	protected Object getSessionAttribute(String key) {
		throw new FrameworkException("prohibit operation");
	}

	public UserContextFactory getUserContextFactory() {
		return this.userContextFactory;
	}

	public void setUserContextFactory(UserContextFactory userContextFactory) {
		this.userContextFactory = userContextFactory;
	}

	public UserContext getUserContext() throws UnLoginException {
		return this.userContextFactory.getLoggedInUser();
	}

	public void setUserContext(UserContext context) {
		throw new FrameworkException("prohibit operation");
	}

	public void fillModifyReccordInfo(Recordable rec) throws UnLoginException {
		Date current = new Date(System.currentTimeMillis());
		String user = getUserContextFactory().getLoggedInUser().getUserCode();
		rec.setModifier(user);
		rec.setModifyTime(current);
	}

	public void fillNewReccordInfo(Recordable rec) throws UnLoginException {
		Date current = new Date(System.currentTimeMillis());
		String user = getUserContextFactory().getLoggedInUser().getUserCode();
		rec.setCreateTime(current);
		rec.setCreator(user);
		rec.setModifier(user);
		rec.setModifyTime(current);
	}

	public String execute() throws Exception {
		return "success";
	}
}
