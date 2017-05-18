package com.free.studio.framework.core.modular;

import java.util.Set;

/**
 * @Title: ModularInterface.java
 * @Package com.free.studio.framework.core.modular
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:45:40
 * @version V1.0
 */
public class ModularInterface {
	private String module;
	private String version;
	private String endpoint;
	private Set<String> interfaces;

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Set<String> getInterfaces() {
		return this.interfaces;
	}

	public void setInterfaces(Set<String> interfaces) {
		this.interfaces = interfaces;
	}

	public String getEndpoint() {
		return this.endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
}
