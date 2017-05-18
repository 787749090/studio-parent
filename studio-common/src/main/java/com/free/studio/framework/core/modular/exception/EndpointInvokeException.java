package com.free.studio.framework.core.modular.exception;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: EndpointInvokeException.java
 * @Package com.free.studio.framework.core.modular.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:49:28
 * @version V1.0
 */
public class EndpointInvokeException extends FrameworkException {
	private static final long serialVersionUID = -7346382266474874683L;

	public EndpointInvokeException(String interfaceName, String endpoint) {
		super(interfaceName + " invoke error.endpoint:" + endpoint);
	}
}
