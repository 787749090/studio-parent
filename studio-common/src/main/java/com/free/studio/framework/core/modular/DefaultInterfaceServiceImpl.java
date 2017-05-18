package com.free.studio.framework.core.modular;

import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.modular.exception.InterfaceDependOnException;

/**
 * @Title: DefaultInterfaceServiceImpl.java
 * @Package com.free.studio.framework.core.modular
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:43:43
 * @version V1.0
 */
@Deprecated
public class DefaultInterfaceServiceImpl implements InterfaceService {
	private InterfaceDependOnRegistry interfaceDependOnRegistry;

	public <T extends ModularFacade> T getFacade(Class<T> type) {
		String interfaceName = type.getName();
		ModularInterface module = this.interfaceDependOnRegistry.getModuleByInterface(interfaceName);

		ApplicationContext moduleContext = ContextManager.getModuleContext(module.getModule());

		InterfacePublisher publisher = (InterfacePublisher) moduleContext.getBean(InterfacePublisher.class);
		if (publisher.hasInterface(interfaceName) == true) {
			ModularFacade facade = (ModularFacade) moduleContext.getBean(type);
			return (T) facade;
		}
		throw new InterfaceDependOnException(module.getModule(), interfaceName);
	}

	public InterfaceDependOnRegistry getInterfaceDependOnRegistry() {
		return this.interfaceDependOnRegistry;
	}

	public void setInterfaceDependOnRegistry(InterfaceDependOnRegistry interfaceDependOnRegistry) {
		this.interfaceDependOnRegistry = interfaceDependOnRegistry;
	}
}
