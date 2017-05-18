package com.free.studio.framework.core.modular.endpoint;

import org.aopalliance.intercept.MethodInvocation;

import com.free.studio.framework.core.modular.ModularInterface;

/**
 * @Title: InvokeStrategy.java
 * @Package com.free.studio.framework.core.modular.endpoint
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:46:57
 * @version V1.0
 */
public interface InvokeStrategy {
	public Object invoke(ModularInterface paramModularInterface, MethodInvocation paramMethodInvocation);
}
