package com.free.studio.framework.core.context.resource;

/**
 * @Title: XmlBuilder.java
 * @Package com.free.studio.framework.core.context.resource
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:22:16
 * @version V1.0
 */
public class XmlBuilder {
	private StringBuilder xml = new StringBuilder();
	private boolean isBuilt = false;

	public XmlBuilder() {
		buildHeader();
	}

	public String toXml() {
		if (!this.isBuilt) {
			buildFooter();
			this.isBuilt = true;
		}
		return this.xml.toString();
	}

	private void buildHeader() {
		this.xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		this.xml.append(
				"<beans xmlns=\"http://www.springframework.org/schema/beans\"                                                                ");
		this.xml.append(
				"\txmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"                                                                   ");
		this.xml.append(
				"\txmlns:aop=\"http://www.springframework.org/schema/aop\"                                                                   ");
		this.xml.append(
				"\txmlns:context=\"http://www.springframework.org/schema/context\"                                                           ");
		this.xml.append(
				"\txsi:schemaLocation=\"                                                                                                    ");
		this.xml.append(
				"     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.1.xsd   ");
		this.xml.append(
				"     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.1.xsd         ");
		this.xml.append(
				"     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.1.xsd\">             ");
	}

	public void addBean(String beanString) {
		if (this.isBuilt == true) {
			throw new RuntimeException("toXml() has been called.");
		}
		this.xml.append(beanString);
	}

	private void buildFooter() {
		this.xml.append("</beans>");
	}
}
