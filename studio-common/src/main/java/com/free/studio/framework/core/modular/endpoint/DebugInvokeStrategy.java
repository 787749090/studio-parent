package com.free.studio.framework.core.modular.endpoint;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.free.studio.framework.core.modular.ModularInterface;

/**
 * @Title: DebugInvokeStrategy.java
 * @Package com.free.studio.framework.core.modular.endpoint
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:46:24
 * @version V1.0
 */
public class DebugInvokeStrategy implements InvokeStrategy {
	public Object invoke(ModularInterface mi, MethodInvocation invocation) {
		Method method = invocation.getMethod();
		Class returnType = method.getReturnType();
		try {
			if (returnType.isInterface()) {
				return null;
			}
			BeanWrapper wrap = new BeanWrapperImpl(returnType);
			return wrap.getWrappedInstance();
		} catch (Exception e) {
		}
		return null;
	}
}
