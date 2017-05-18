package com.free.studio.framework.core.security;

/**
 * @Title: SimpleUserContext.java
 * @Package com.free.studio.framework.core.security
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:15:07
 * @version V1.0
 */
public class SimpleUserContext implements UserContext {
	private static final long serialVersionUID = -5226645667134263738L;
	private String userCode;
	private String enterpriseCode;
	private String userName;
	private String enterpriseName;

	public String uid() {
		return this.userCode;
	}

	public String getUserCode() {
		return this.userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getEnterpriseCode() {
		return this.enterpriseCode;
	}

	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEnterpriseName() {
		return this.enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
}
