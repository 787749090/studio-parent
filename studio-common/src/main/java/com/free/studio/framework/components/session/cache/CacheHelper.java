package com.free.studio.framework.components.session.cache;

import com.free.studio.framework.components.session.cache.ehcache.StandardCacheConfigurationBuilder;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.Configuration;

/**
 * @Title: CacheHelper.java
 * @Package com.free.studio.framework.components.session.cache
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:54:08
 * @version V1.0
 */
public class CacheHelper {
	public static final NotCache NONE_CACHE = new NotCache();
	private CacheManager cacheManager;

	public CacheHelper(SimpleCacheConfig simple) {
		Configuration configuration = getConfigurationBuilder().generate(simple);
		this.cacheManager = new CacheManager(configuration);
	}

	protected CacheConfigurationBuilder getConfigurationBuilder() {
		return new StandardCacheConfigurationBuilder();
	}

	public Object getValue(String cacheName, Object elKey) {
		Cache cache = getCache(cacheName);
		Element el = cache.get(elKey);
		if (el != null) {
			return el.getObjectValue();
		}
		return NONE_CACHE;
	}

	public void putValue(String cacheName, Object elKey, Object value) {
		Cache cache = getCache(cacheName);
		Element el = new Element(elKey, value);
		cache.put(el);
	}

	private Cache getCache(String cacheName) {
		if (this.cacheManager == null) {
			throw new RuntimeException("cacheManager  is not initialized");
		}
		Cache cache = this.cacheManager.getCache(cacheName);
		return cache;
	}
}
