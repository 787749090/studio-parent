package com.free.studio.framework.components.options.xml;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Title: OptionsNamespaceHandler.java
 * @Package com.free.studio.framework.components.options.xml
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:52:36
 * @version V1.0
 */
public class OptionsNamespaceHandler extends NamespaceHandlerSupport {
	public void init() {
		registeParser(new ConstantOptionsDefinitionParser());
		registeParser(new I18nConstantOptionsDefinitionParser());
	}

	private void registeParser(ConstantOptionsDefinitionParser parser) {
		registerBeanDefinitionParser(parser.getElementName(), parser);
	}
}
