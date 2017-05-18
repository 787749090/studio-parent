package com.free.studio.framework.core.modular;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.cglib.proxy.MethodInterceptor;

import com.free.studio.framework.core.modular.endpoint.InvokeStrategy;
import com.free.studio.framework.core.modular.endpoint.InvokeStrategyFactory;

/**
 * @Title: InterfaceServiceInterceptor.java
 * @Package com.free.studio.framework.core.modular
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:45:06
 * @version V1.0
 */
public abstract class InterfaceServiceInterceptor implements MethodInterceptor, BeanFactoryAware {
	public static final String INTERCEPTOR_BEAN_NAME = "InterfaceServiceInterceptor";
	private BeanFactory beanfactory;

	public Object invoke(MethodInvocation invocation) throws Throwable {
		InterfaceDependOnRegistry registry = (InterfaceDependOnRegistry) this.beanfactory
				.getBean(InterfaceDependOnRegistry.class);
		Method method = invocation.getMethod();
		Class type = method.getDeclaringClass();
		ModularInterface mi = registry.getModuleByInterface(type.getName());

		InvokeStrategy strategy = InvokeStrategyFactory.getStrategy(mi);

		return strategy.invoke(mi, invocation);
	}

	public void setBeanFactory(BeanFactory beanfactory) throws BeansException {
		this.beanfactory = beanfactory;
	}
}
