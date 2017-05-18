package com.free.studio.framework.core.modular.endpoint;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
import org.springframework.util.ReflectionUtils;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.modular.InterfacePublisher;
import com.free.studio.framework.core.modular.ModularFacade;
import com.free.studio.framework.core.modular.ModularInterface;
import com.free.studio.framework.core.modular.exception.InterfaceDependOnException;

/**
 * @Title: LocalInvokeStrategy.java
 * @Package com.free.studio.framework.core.modular.endpoint
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:47:25
 * @version V1.0
 */
public class LocalInvokeStrategy implements InvokeStrategy {
	public Object invoke(ModularInterface mi, MethodInvocation invocation) {
		Method method = invocation.getMethod();
		Class type = method.getDeclaringClass();
		ModularFacade facade = getFacade(mi, type);
		if (facade != null) {
			Method facadeMethod = ReflectionUtils.findMethod(type, method.getName(), method.getParameterTypes());
			return ReflectionUtils.invokeMethod(facadeMethod, facade, invocation.getArguments());
		}
		return null;
	}

	private ModularFacade getFacade(ModularInterface mi, Class type) {
		String interfaceName = type.getName();
		ModularFacade facade = null;

		ApplicationContext moduleContext = ContextManager.getModuleContext(mi.getModule());

		InterfacePublisher publisher = (InterfacePublisher) moduleContext.getBean(InterfacePublisher.class);
		if (publisher.hasInterface(interfaceName) == true) {
			facade = (ModularFacade) moduleContext.getBean(type);
		} else {
			throw new InterfaceDependOnException(mi.getModule(), interfaceName);
		}
		return facade;
	}
}
