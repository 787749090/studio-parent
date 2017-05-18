package com.free.studio.framework.core.context.exception;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: ContextNotFoundException.java
 * @Package com.free.studio.framework.core.context.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:20:50
 * @version V1.0
 */
public class ContextNotFoundException extends FrameworkException {
	public ContextNotFoundException(String module) {
		super(module);
	}

	public ContextNotFoundException(String module, Throwable cause) {
		super(module, cause);
	}
}
