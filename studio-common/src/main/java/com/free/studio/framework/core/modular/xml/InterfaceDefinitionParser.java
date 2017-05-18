package com.free.studio.framework.core.modular.xml;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Element;

import com.free.studio.framework.core.modular.DefaultInterfaceDependOnRegistryImpl;
import com.free.studio.framework.core.modular.InterfaceServiceInterceptor;
import com.free.studio.framework.core.modular.ModularInterface;

/**
 * @Title: InterfaceDefinitionParser.java
 * @Package com.free.studio.framework.core.modular.xml
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:50:35
 * @version V1.0
 */
public class InterfaceDefinitionParser extends AbstractSingleBeanDefinitionParser {
	private static final String MODULES_FIELD_NAME = "modules";
	private static final String MODULE_ELEMENT = "modules";
	private static final String MODULE_NAME_ATTR = "name";
	private static final String MODULE_VERSION_ATTR = "version";
	private static final String MODULE_ENDPOINT_ATTR = "endpoint";
	private static final String FACADE_ELEMENT = "facade";

	protected Class<?> getBeanClass(Element element) {
		return DefaultInterfaceDependOnRegistryImpl.class;
	}

	protected void doParse(Element element, ParserContext parserContext, BeanDefinitionBuilder bean) {
		BeanDefinitionBuilder interceptor = BeanDefinitionBuilder
				.genericBeanDefinition(InterfaceServiceInterceptor.class);
		String id = parserContext.getReaderContext().registerWithGeneratedName(interceptor.getBeanDefinition());

		bean.addPropertyValue("interceptorName", id);

		Set<ModularInterface> modules = parseModules(element);

		bean.addPropertyValue("modules", modules);
	}

	private Set<ModularInterface> parseModules(Element element) {
		Set<ModularInterface> modules = new HashSet();
		List<Element> nodeList = DomUtils.getChildElements(element);

		int len = nodeList.size();
		for (int i = 0; i < len; i++) {
			Element node = (Element) nodeList.get(i);
			ModularInterface mi = parseModule(node);
			modules.add(mi);
		}
		return modules;
	}

	private ModularInterface parseModule(Element element) {
		ModularInterface mi = new ModularInterface();
		mi.setModule(element.getAttribute("name"));
		mi.setVersion(element.getAttribute("version"));
		mi.setEndpoint(element.getAttribute("endpoint"));

		List<Element> nodeList = DomUtils.getChildElements(element);

		int len = nodeList.size();
		Set<String> facades = new HashSet();
		for (int i = 0; i < len; i++) {
			Element node = (Element) nodeList.get(i);
			String facade = DomUtils.getTextValue(node);
			if ((facade != null) && (facade.length() > 0)) {
				facades.add(facade.trim());
			}
		}
		mi.setInterfaces(facades);

		return mi;
	}
}
