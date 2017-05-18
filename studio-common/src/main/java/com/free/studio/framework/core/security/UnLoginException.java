package com.free.studio.framework.core.security;

import com.free.studio.framework.core.exception.UnifiedHandlingException;

/**
 * @Title: UnLoginException.java
 * @Package com.free.studio.framework.core.security
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:15:46
 * @version V1.0
 */
public class UnLoginException extends UnifiedHandlingException {
	public static final String LOGIN_ERROR_CODE = "unlogin";

	public UnLoginException() {
		super("unlogin");
	}
}
