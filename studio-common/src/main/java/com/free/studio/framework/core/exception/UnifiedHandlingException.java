package com.free.studio.framework.core.exception;

/**
 * @Title: UnifiedHandlingException.java
 * @Package com.free.studio.framework.core.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:29:52
 * @version V1.0
 */
public class UnifiedHandlingException extends Exception {
	public UnifiedHandlingException() {
	}

	public UnifiedHandlingException(String message) {
		super(message);
	}

	public UnifiedHandlingException(Throwable cause) {
		super(cause);
	}

	public UnifiedHandlingException(String message, Throwable cause) {
		super(message, cause);
	}
}
