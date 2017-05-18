package com.free.studio.framework.core.modular.exception;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: InterfaceDependOnException.java
 * @Package com.free.studio.framework.core.modular.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:49:45
 * @version V1.0
 */
public class InterfaceDependOnException extends FrameworkException {
	public InterfaceDependOnException(String module, String interfaceName) {
		super(interfaceName + " is not published in the " + module + " module.");
	}
}
