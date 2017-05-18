package com.free.studio.framework.components.session.cache;

/**
 * @Title: MulticastScope.java
 * @Package com.free.studio.framework.components.session.cache
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:54:21
 * @version V1.0
 */
public enum MulticastScope {
	SAME_HOST("host", 0), SAME_SUBNET("subnet", 1), SAME_SITE("site", 32), SMAE_REGION("region",
			64), SAME_CONTINENT("continent", 128), UNRESTRICTED("unrestricted", 255);

	private int timeToLive;

	private MulticastScope(String name, int timeToLive) {
		this.timeToLive = timeToLive;
	}

	public int getTimeToLive() {
		return this.timeToLive;
	}
}
