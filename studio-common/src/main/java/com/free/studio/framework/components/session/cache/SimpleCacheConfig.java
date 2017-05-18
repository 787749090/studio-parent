package com.free.studio.framework.components.session.cache;

/**
 * @Title: SimpleCacheConfig.java
 * @Package com.free.studio.framework.components.session.cache
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:54:57
 * @version V1.0
 */
public class SimpleCacheConfig {
	private String cacheName;
	private int maxElementsInMemory = 1000;
	private int maxElementsOnDisk = 0;
	private int timeToIdleSeconds = 1800;
	private int timeToLiveSeconds = 0;
	private String multicastGroupAddress = "230.0.0.1";
	private int multicastGroupPort = 4446;
	private MulticastScope multicastScope;
	private String hostName;
	private int port;

	public String getCacheName() {
		return this.cacheName;
	}

	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

	public int getMaxElementsInMemory() {
		return this.maxElementsInMemory;
	}

	public void setMaxElementsInMemory(int maxElementsInMemory) {
		this.maxElementsInMemory = maxElementsInMemory;
	}

	public int getMaxElementsOnDisk() {
		return this.maxElementsOnDisk;
	}

	public void setMaxElementsOnDisk(int maxElementsOnDisk) {
		this.maxElementsOnDisk = maxElementsOnDisk;
	}

	public int getTimeToIdleSeconds() {
		return this.timeToIdleSeconds;
	}

	public void setTimeToIdleSeconds(int timeToIdleSeconds) {
		this.timeToIdleSeconds = timeToIdleSeconds;
	}

	public String getMulticastGroupAddress() {
		return this.multicastGroupAddress;
	}

	public void setMulticastGroupAddress(String multicastGroupAddress) {
		this.multicastGroupAddress = multicastGroupAddress;
	}

	public int getMulticastGroupPort() {
		return this.multicastGroupPort;
	}

	public void setMulticastGroupPort(int multicastGroupPort) {
		this.multicastGroupPort = multicastGroupPort;
	}

	public MulticastScope getMulticastScope() {
		return this.multicastScope;
	}

	public void setMulticastScope(MulticastScope multicastScope) {
		this.multicastScope = multicastScope;
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

	public int getTimeToLiveSeconds() {
		return this.timeToLiveSeconds;
	}

	public void setTimeToLiveSeconds(int timeToLiveSeconds) {
		this.timeToLiveSeconds = timeToLiveSeconds;
	}
}
