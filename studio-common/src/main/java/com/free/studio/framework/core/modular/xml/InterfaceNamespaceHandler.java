package com.free.studio.framework.core.modular.xml;

import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Title: InterfaceNamespaceHandler.java
 * @Package com.free.studio.framework.core.modular.xml
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:51:25
 * @version V1.0
 */
public class InterfaceNamespaceHandler extends NamespaceHandlerSupport {
	public void init() {
		registerBeanDefinitionParser("InterfaceDependOnRegistry",
				(BeanDefinitionParser) new InterfaceDefinitionParser());
	}
}
