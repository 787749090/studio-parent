package com.free.studio.framework.core.support.web.tag.input.attribute;

import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @Title: CommonAttribute.java
 * @Package com.free.studio.framework.core.support.web.tag.input.attribute
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:02:14
 * @version V1.0
 */
public class CommonAttribute extends SimpleTagSupport {

	private String id;
	private String name;
	private String disabled;
	private String readonly;
	private String cssClass;
	private String querycondition;

	public String getCommonAttribute() {
		StringBuffer attribute = new StringBuffer();
		if (null != getId()) {
			attribute.append("id='" + getId() + "' ");
		}
		if (null != getName()) {
			attribute.append("name='" + getName() + "' ");
		}
		if (null != getCssClass()) {
			attribute.append("class='" + getCssClass() + "' ");
		}
		if (null != getDisabled()) {
			attribute.append("disabled='" + getDisabled() + "' ");
		}
		if (null != getReadonly()) {
			attribute.append("readonly='" + getReadonly() + "' ");
		}
		if (null != getQuerycondition()) {
			attribute.append("querycondition='" + getQuerycondition() + "' ");
		}
		return attribute.toString();
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisabled() {
		return this.disabled;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public String getReadonly() {
		return this.readonly;
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getCssClass() {
		return this.cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getQuerycondition() {
		return this.querycondition;
	}

	public void setQuerycondition(String querycondition) {
		this.querycondition = querycondition;
	}
}
