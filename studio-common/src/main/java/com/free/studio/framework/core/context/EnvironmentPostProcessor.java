package com.free.studio.framework.core.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;

import com.free.studio.framework.core.Environment;

/**
 * @Title: EnvironmentPostProcessor.java
 * @Package com.free.studio.framework.core.context
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:16:41
 * @version V1.0
 */
public class EnvironmentPostProcessor implements BeanFactoryPostProcessor {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private String module;
	private String version;

	EnvironmentPostProcessor(String module, String version) {
		this.module = module;
		this.version = version;
	}

	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		BeanDefinition def = factory.getBeanDefinition(Environment.class.getSimpleName());
		ConstructorArgumentValues args = def.getConstructorArgumentValues();

		args.addIndexedArgumentValue(0, this.module);
		args.addIndexedArgumentValue(1, this.version);
		this.logger.info("reset Environment:module={},version={}.", this.module, this.version);
	}
}
