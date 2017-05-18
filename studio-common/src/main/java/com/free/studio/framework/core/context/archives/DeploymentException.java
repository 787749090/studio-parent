package com.free.studio.framework.core.context.archives;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: DeploymentException.java
 * @Package com.free.studio.framework.core.context.archives
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:19:13
 * @version V1.0
 */
public class DeploymentException extends FrameworkException {
	private static final long serialVersionUID = 1L;

	public DeploymentException(String message) {
		super(message);
	}

	public DeploymentException(String message, Throwable cause) {
		super(message, cause);
	}
}
