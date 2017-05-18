package com.free.studio.framework.core.modular.endpoint;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;

import com.caucho.hessian.client.HessianProxyFactory;
import com.free.studio.framework.core.modular.ModularInterface;
import com.free.studio.framework.core.modular.exception.RemoteEndpointException;

/**
 * @Title: RemoteInvokeStrategy.java
 * @Package com.free.studio.framework.core.modular.endpoint
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:47:44
 * @version V1.0
 */
public class RemoteInvokeStrategy implements InvokeStrategy {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public Object invoke(ModularInterface mi, MethodInvocation invocation) {
		Method method = invocation.getMethod();
		Class interfaceType = method.getDeclaringClass();
		String endpoint = mi.getEndpoint();
		StringBuffer url = new StringBuffer(endpoint.length() + 300);
		url.append(endpoint);
		if (!endpoint.endsWith("/")) {
			url.append("/");
		}
		url.append("rpcServer.shtml?module=");
		url.append(mi.getModule());
		url.append("&interfaceName=");
		url.append(interfaceType.getName());

		this.logger.debug("remote url is {}", url);
		try {
			HessianProxyFactory factory = new HessianProxyFactory();
			Object interfaceObj = factory.create(interfaceType, url.toString());
			if (interfaceObj != null) {
				Method interfaceMethod = ReflectionUtils.findMethod(interfaceType, method.getName(),
						method.getParameterTypes());

				return ReflectionUtils.invokeMethod(interfaceMethod, interfaceObj, invocation.getArguments());
			}
		} catch (Exception e) {
			throw new RemoteEndpointException(interfaceType.getName(), endpoint, url.toString(), e);
		}
		return null;
	}
}
