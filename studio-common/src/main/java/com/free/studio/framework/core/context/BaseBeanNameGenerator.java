package com.free.studio.framework.core.context;

import java.net.ProxySelector;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

/**
 * @Title: BaseBeanNameGenerator.java
 * @Package com.free.studio.framework.core.context
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:14:55
 * @version V1.0
 */
public class BaseBeanNameGenerator extends AnnotationBeanNameGenerator {
	public String generateBeanName(BeanDefinition definition, BeanDefinitionRegistry registry) {
		try {
			ProxySelector.setDefault(null);
		} catch (Exception e) {
		}
		String beanName = super.generateBeanName(definition, registry);
		if (beanName.endsWith("Impl")) {
			beanName = beanName.substring(0, beanName.length() - 4);
		}
		return beanName;
	}
}
