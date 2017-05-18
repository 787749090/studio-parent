package com.free.studio.framework.components.options.xml;

import java.util.List;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import com.free.studio.framework.components.options.OptionItem;
import com.free.studio.framework.components.options.impl.ConstantOptionsSource;

/**
 * @Title: ConstantOptionsDefinitionParser.java
 * @Package com.free.studio.framework.components.options.xml
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:51:53
 * @version V1.0
 */
public class ConstantOptionsDefinitionParser extends AbstractSingleBeanDefinitionParser {
	private static final String ROOT_ELEMENT = "ConstantOptions";

	public String getElementName() {
		return "ConstantOptions";
	}

	protected Class<?> getBeanClass(Element element) {
		return ConstantOptionsSource.class;
	}

	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder bean) {
		String type = element.getAttribute("type");
		bean.addPropertyValue("type", type);

		OptionItem[] items = parseOptions(element);

		bean.addPropertyValue("items", items);
	}

	protected OptionItem[] parseOptions(Element element) {
		List<Element> nodeList = DomUtils.getChildElements(element);
		OptionItem[] items = new OptionItem[nodeList.size()];
		int len = nodeList.size();
		String keyType = null;
		String valType = null;
		for (int i = 0; i < len; i++) {
			Element node = (Element) nodeList.get(i);

			items[i] = new OptionItem();
			keyType = node.getAttribute("keyType");
			valType = node.getAttribute("valueType");

			items[i].setKey(convert(node.getAttribute("key"), keyType));
			items[i].setValue(convert(node.getAttribute("value"), valType));
		}
		return items;
	}

	private Object convert(String str, String type) {
		if ((type == null) || (type.length() < 1)) {
			return str;
		}
		if ("int".equalsIgnoreCase(type)) {
			return Integer.valueOf(Integer.parseInt(str));
		}
		if ("float".equalsIgnoreCase(type)) {
			return Float.valueOf(Float.parseFloat(str));
		}
		if ("long".equalsIgnoreCase(type)) {
			return Long.valueOf(Long.parseLong(str));
		}
		if ("double".equalsIgnoreCase(type)) {
			return Double.valueOf(Double.parseDouble(str));
		}
		return str;
	}
}
