package com.free.studio.framework.core.exception;

/**
 * @Title: SpecialHandlingException.java
 * @Package com.free.studio.framework.core.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:29:28
 * @version V1.0
 */
public class SpecialHandlingException extends Exception {
	public SpecialHandlingException() {
	}

	public SpecialHandlingException(String message, Throwable cause) {
		super(message, cause);
	}

	public SpecialHandlingException(String message) {
		super(message);
	}

	public SpecialHandlingException(Throwable cause) {
		super(cause);
	}
}
