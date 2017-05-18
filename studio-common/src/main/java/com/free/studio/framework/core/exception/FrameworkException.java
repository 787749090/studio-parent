package com.free.studio.framework.core.exception;

/**
 * @Title: FrameworkException.java
 * @Package com.free.studio.framework.core.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:28:49
 * @version V1.0
 */
public class FrameworkException extends RuntimeException {
	private static final long serialVersionUID = -4401507743528660409L;
	public static final String MSG_KEY_PREFIX = "error.";

	public FrameworkException(String message) {
		super(message);
	}

	public FrameworkException(String message, Throwable cause) {
		super(message, cause);
	}
}
