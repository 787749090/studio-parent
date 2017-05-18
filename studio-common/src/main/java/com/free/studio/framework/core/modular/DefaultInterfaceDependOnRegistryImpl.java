package com.free.studio.framework.core.modular;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.modular.exception.InterfaceDependOnException;

/**
 * @Title: DefaultInterfaceDependOnRegistryImpl.java
 * @Package com.free.studio.framework.core.modular
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:43:07
 * @version V1.0
 */
public class DefaultInterfaceDependOnRegistryImpl extends ProxyFactoryBean
		implements InterfaceDependOnRegistry, InterfaceService, InitializingBean {
	private static final long serialVersionUID = 2966334457760317589L;
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Set<ModularInterface> modules;
	private Map<String, ModularInterface> knowInterfaces;
	private String interceptorName;

	public void afterPropertiesSet() throws Exception {
		initKnowInterfaces();
		registryProxyInterfaces(this.knowInterfaces);
		registryInterceptorNames();
	}

	public <T extends ModularFacade> T getFacade(Class<T> type) {
		String interfaceName = type.getName();
		ModularInterface mi = getModuleByInterface(interfaceName);
		String module = mi.getModule();
		String endpoint = mi.getEndpoint();
		if (endpoint != null) {
			if (ContextManager.hasModule(module)) {
				ApplicationContext moduleContext = ContextManager.getModuleContext(module);

				InterfacePublisher publisher = (InterfacePublisher) moduleContext.getBean(InterfacePublisher.class);
				if (publisher.hasInterface(interfaceName) == true) {
					ModularFacade facade = (ModularFacade) moduleContext.getBean(type);
					return (T) facade;
				}
				throw new InterfaceDependOnException(module, interfaceName);
			}
			return (T) getObject();
		}
		throw new InterfaceDependOnException(module, interfaceName);
	}

	private void registryProxyInterfaces(Map<String, ModularInterface> interfaces) {
		BeanWrapper wrap = new BeanWrapperImpl(this);
		Set<String> set = new HashSet();
		for (Iterator iter = interfaces.keySet().iterator(); iter.hasNext();) {
			set.add((String) iter.next());
		}
		wrap.setPropertyValue("proxyInterfaces", set);
		this.logger.info("registry Interfaces:" + set);
	}

	private void registryInterceptorNames() {
		BeanWrapper wrap = new BeanWrapperImpl(this);
		Set<String> set = new HashSet();
		if (this.interceptorName != null) {
			set.add(this.interceptorName);
		} else {
			set.add("InterfaceServiceInterceptor");
		}
		wrap.setPropertyValue("interceptorNames", set);
	}

	private void initKnowInterfaces() {
		ModularInterface mi;
		Iterator faces;
		if (this.knowInterfaces == null) {
			this.knowInterfaces = new HashMap();
		}
		if (this.modules == null) {
			return;
		}
		for (Iterator iter = this.modules.iterator(); iter.hasNext();) {
			mi = (ModularInterface) iter.next();

			Set<String> ifSet = mi.getInterfaces();
			if (ifSet != null) {
				for (faces = ifSet.iterator(); faces.hasNext();) {
					String className = (String) faces.next();
					this.knowInterfaces.put(className, mi);
				}
			}
		}
	}

	public ModularInterface getModuleByInterface(String interfaceKey) {
		return (ModularInterface) this.knowInterfaces.get(interfaceKey);
	}

	public Set<ModularInterface> getModules() {
		return this.modules;
	}

	public void setModules(Set<ModularInterface> modules) {
		this.modules = modules;
	}

	public String getInterceptorName() {
		return this.interceptorName;
	}

	public void setInterceptorName(String interceptorName) {
		this.interceptorName = interceptorName;
	}
}
