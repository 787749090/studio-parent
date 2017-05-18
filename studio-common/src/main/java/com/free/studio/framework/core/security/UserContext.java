package com.free.studio.framework.core.security;

import java.io.Serializable;

/**
 * @Title: UserContext.java
 * @Package com.free.studio.framework.core.security
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:16:05
 * @version V1.0
 */
public interface UserContext extends Serializable {
	public abstract String uid();

	public abstract String getUserCode();

	public abstract String getUserName();

	public abstract String getEnterpriseCode();

	public abstract String getEnterpriseName();
}
