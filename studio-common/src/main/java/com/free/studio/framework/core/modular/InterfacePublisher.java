package com.free.studio.framework.core.modular;

import java.util.HashSet;
import java.util.Set;

/**
 * @Title: InterfacePublisher.java
 * @Package com.free.studio.framework.core.modular
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:44:31
 * @version V1.0
 */
public class InterfacePublisher {
	private Set<String> interfaces = new HashSet();

	public boolean hasInterface(String name) {
		return this.interfaces.contains(name);
	}

	public Set<String> getInterfaces() {
		return this.interfaces;
	}

	public void setInterfaces(Set<String> interfaces) {
		this.interfaces = interfaces;
	}
}
