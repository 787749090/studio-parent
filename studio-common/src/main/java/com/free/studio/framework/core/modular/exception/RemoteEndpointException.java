package com.free.studio.framework.core.modular.exception;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: RemoteEndpointException.java
 * @Package com.free.studio.framework.core.modular.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:50:03
 * @version V1.0
 */
public class RemoteEndpointException extends FrameworkException {
	private static final long serialVersionUID = -7346382266474874683L;

	public RemoteEndpointException(String interfaceName, String endpoint, String url) {
		super(interfaceName + " invoke error.endpoint:[" + endpoint + "],url:[" + url + "]");
	}

	public RemoteEndpointException(String interfaceName, String endpoint, String url, Throwable cause) {
		super(interfaceName + " invoke error.endpoint:[" + endpoint + "],url:[" + url + "]", cause);
	}
}
