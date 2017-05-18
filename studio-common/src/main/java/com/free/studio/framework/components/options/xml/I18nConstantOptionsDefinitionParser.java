package com.free.studio.framework.components.options.xml;

import org.w3c.dom.Element;

import com.free.studio.framework.components.options.impl.I18nConstantOptionsSource;

/**
 * @Title: I18nConstantOptionsDefinitionParser.java
 * @Package com.free.studio.framework.components.options.xml
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:52:19
 * @version V1.0
 */
public class I18nConstantOptionsDefinitionParser extends ConstantOptionsDefinitionParser {
	public static final String ROOT_ELEMENT = "I18nOptions";

	public String getElementName() {
		return "I18nOptions";
	}

	protected Class<?> getBeanClass(Element element) {
		return I18nConstantOptionsSource.class;
	}
}
