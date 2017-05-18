package com.free.studio.framework.components.session.cache.ehcache;

import java.text.MessageFormat;

import com.free.studio.framework.components.session.cache.CacheConfigurationBuilder;
import com.free.studio.framework.components.session.cache.SimpleCacheConfig;

import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;
import net.sf.ehcache.config.FactoryConfiguration;
import net.sf.ehcache.distribution.RMICacheManagerPeerListenerFactory;
import net.sf.ehcache.distribution.RMICacheManagerPeerProviderFactory;

/**
 * @Title: StandardCacheConfigurationBuilder.java
 * @Package com.free.studio.framework.components.session.cache.ehcache
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:55:49
 * @version V1.0
 */
public class StandardCacheConfigurationBuilder implements CacheConfigurationBuilder {
	public Configuration generate(SimpleCacheConfig simple) {
		Configuration cfg = new Configuration();

		CacheConfiguration cc = generateCacheConfig(simple);
		cfg.addCache(cc);

		FactoryConfiguration providerFactory = generateProviderFactory(simple);
		cfg.addCacheManagerPeerProviderFactory(providerFactory);

		FactoryConfiguration listenerFactory = generateListenerFactory(simple);
		cfg.addCacheManagerPeerListenerFactory(listenerFactory);

		return cfg;
	}

	private FactoryConfiguration generateListenerFactory(SimpleCacheConfig simple) {
		FactoryConfiguration factory = new FactoryConfiguration();
		factory.setClass(RMICacheManagerPeerListenerFactory.class.getName());
		String pattern = "hostName={0},port={1,number,#},socketTimeoutMillis=2000";
		String props = MessageFormat.format(pattern,
				new Object[] { simple.getHostName(), Integer.valueOf(simple.getPort()) });
		factory.setProperties(props);
		return factory;
	}

	private FactoryConfiguration generateProviderFactory(SimpleCacheConfig simple) {
		FactoryConfiguration factory = new FactoryConfiguration();
		factory.setClass(RMICacheManagerPeerProviderFactory.class.getName());
		String pattern = "peerDiscovery=automatic, multicastGroupAddress={0},multicastGroupPort={1,number,#},timeToLive={2,number,#}";
		String props = MessageFormat
				.format(pattern,
						new Object[] { simple.getMulticastGroupAddress(),
								Integer.valueOf(simple.getMulticastGroupPort()),
								Integer.valueOf(simple.getMulticastScope().getTimeToLive()) });

		factory.setProperties(props);
		return factory;
	}

	private CacheConfiguration generateCacheConfig(SimpleCacheConfig simple) {
		CacheConfiguration cc = new CacheConfiguration();
		cc.setName(simple.getCacheName());
		cc.setMaxElementsInMemory(simple.getMaxElementsInMemory());
		cc.setMaxElementsOnDisk(simple.getMaxElementsOnDisk());
		cc.setTimeToIdleSeconds(simple.getTimeToIdleSeconds());
		cc.setTimeToLiveSeconds(simple.getTimeToLiveSeconds());

		cc.overflowToDisk(false);
		cc.setEternal(false);
		cc.setMemoryStoreEvictionPolicy("LFU");

		CacheConfiguration.CacheEventListenerFactoryConfiguration eventFactory = new CacheConfiguration.CacheEventListenerFactoryConfiguration();
		eventFactory.setClass("net.sf.ehcache.distribution.RMICacheReplicatorFactory");
		StringBuffer props = new StringBuffer();
		props.append("replicateAsynchronously=true,");
		props.append("replicatePuts=true,");
		props.append("replicateUpdates=true,");
		props.append("replicateUpdatesViaCopy=false,");
		props.append("replicateRemovals=true,");
		eventFactory.setProperties(props.toString());
		cc.addCacheEventListenerFactory(eventFactory);

		CacheConfiguration.BootstrapCacheLoaderFactoryConfiguration factory = new CacheConfiguration.BootstrapCacheLoaderFactoryConfiguration();
		factory.className("net.sf.ehcache.distribution.RMIBootstrapCacheLoaderFactory");
		cc.addBootstrapCacheLoaderFactory(factory);
		return cc;
	}
}
