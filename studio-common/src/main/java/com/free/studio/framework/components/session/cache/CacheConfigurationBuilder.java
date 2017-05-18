package com.free.studio.framework.components.session.cache;

import net.sf.ehcache.config.Configuration;

/**
 * @Title: CacheConfigurationBuilder.java
 * @Package com.free.studio.framework.components.session.cache
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:53:51
 * @version V1.0
 */
public interface CacheConfigurationBuilder {
	public abstract Configuration generate(SimpleCacheConfig paramSimpleCacheConfig);
}
