package com.free.studio.framework.components.session.cache;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.free.studio.framework.core.security.UserContext;

/**
 * @Title: SessionCache.java
 * @Package com.free.studio.framework.components.session.cache
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:54:44
 * @version V1.0
 */
public class SessionCache {
	private static final String SESSIONID_CACHE_NAME = "sessionid_cache_name";
	private String hostName;
	private int port;
	private int timeToIdleSeconds = 1800;
	private MulticastScope multicastScope = MulticastScope.SAME_HOST;
	private CacheHelper cacheHelper = null;

	public void init() {
		if (this.hostName == null) {
			try {
				this.hostName = InetAddress.getLocalHost().getHostName();
			} catch (UnknownHostException e) {
			}
		}
		SimpleCacheConfig simpleConfig = new SimpleCacheConfig();
		simpleConfig.setCacheName("sessionid_cache_name");
		simpleConfig.setHostName(this.hostName);
		simpleConfig.setPort(this.port);
		simpleConfig.setMulticastScope(this.multicastScope);
		simpleConfig.setTimeToIdleSeconds(this.timeToIdleSeconds);

		this.cacheHelper = new CacheHelper(simpleConfig);
	}

	public UserContext getSessionObject(String sid) {
		Object obj = this.cacheHelper.getValue("sessionid_cache_name", sid);
		if (obj == CacheHelper.NONE_CACHE) {
			return null;
		}
		return (UserContext) obj;
	}

	public void setSessionObject(String sid, UserContext user) {
		this.cacheHelper.putValue("sessionid_cache_name", sid, user);
	}

	public String getHostName() {
		return this.hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeToIdleSeconds() {
		return this.timeToIdleSeconds;
	}

	public void setTimeToIdleSeconds(int timeToIdleSeconds) {
		this.timeToIdleSeconds = timeToIdleSeconds;
	}

	public MulticastScope getMulticastScope() {
		return this.multicastScope;
	}

	public void setMulticastScope(MulticastScope multicastScope) {
		this.multicastScope = multicastScope;
	}
}
