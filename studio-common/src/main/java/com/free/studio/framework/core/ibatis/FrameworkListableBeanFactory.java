package com.free.studio.framework.core.ibatis;

import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.free.studio.framework.core.context.resource.FrameworkResourceManager;

/**
 * @Title: FrameworkListableBeanFactory.java
 * @Package com.free.studio.framework.core.ibatis
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:32:49
 * @version V1.0
 */
public class FrameworkListableBeanFactory extends AbstractXmlApplicationContext {
	public Resource getResource(String location) {
		if (FrameworkResourceManager.isFrameworkResource(location)) {
			return (Resource) FrameworkResourceManager.INSTANCE.get(location);
		}
		return super.getResource(location);
	}
}
