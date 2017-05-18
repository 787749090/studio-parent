package com.free.studio.framework.core.context;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @Title: InheritableListableBeanFactory.java
 * @Package com.free.studio.framework.core.context
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:17:07
 * @version V1.0
 */
public class InheritableListableBeanFactory extends DefaultListableBeanFactory {
	public InheritableListableBeanFactory(BeanFactory parentBeanFactory) {
		super(parentBeanFactory);
	}

	public void registerBeanDefinition(String beanName, BeanDefinition bd) throws BeanDefinitionStoreException {
		BeanDefinition existingBd;
		try {
			existingBd = getBeanDefinition(beanName);
		} catch (NoSuchBeanDefinitionException e) {
			existingBd = null;
		}
		if ((existingBd != null) && ((existingBd instanceof AbstractBeanDefinition))) {
			((AbstractBeanDefinition) existingBd).overrideFrom(bd);
			super.registerBeanDefinition(beanName, existingBd);
		} else {
			super.registerBeanDefinition(beanName, bd);
		}
	}
}
