package com.free.studio.framework.core;

import java.util.Iterator;
import java.util.Map;

/**
 * @Title: Environment.java
 * @Package com.free.studio.framework.core
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:30:34
 * @version V1.0
 */
public class Environment {
	private String moduleName = null;
	private String version = null;
	private String loginPage = null;
	private String homePage = null;
	private String servletProvider = null;
	private String requestExtension = ".shtml";

	public Environment(String moduleName, String version) {
		this.moduleName = moduleName;
		this.version = version;
	}

	public Environment(String moduleName, String version, Map<String, String> configs) {
		this(moduleName, version);
		for (Iterator<Map.Entry<String, String>> iterator = configs.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry) iterator.next();
			if ((!"moduleName".equals(entry.getKey())) && (!"version".equals(entry.getKey()))) {
				ReflectionUtils.setFieldQuietly(getClass(), this, (String) entry.getKey(), entry.getValue());
			}
		}
	}

	public String getModuleName() {
		return this.moduleName;
	}

	public String getVersion() {
		return this.version;
	}

	public String getLoginPage() {
		return this.loginPage;
	}

	public String getHomePage() {
		return this.homePage;
	}

	public String getServletProvider() {
		return this.servletProvider;
	}

	public String getRequestExtension() {
		return this.requestExtension;
	}
}
