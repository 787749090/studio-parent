package com.free.studio.framework.components.options;

/**
 * @Title: Mapping.java
 * @Package com.free.studio.framework.components.options
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:47:47
 * @version V1.0
 */
public class Mapping {
	private String valueField;
	private String displayField;
	private String type;

	public Mapping(String type, String valueField) {
		this(type, valueField, valueField);
	}

	public Mapping(String type, String valueField, String displayField) {
		this.valueField = valueField;
		this.displayField = displayField;
		this.type = type;
	}

	public String getValueField() {
		return this.valueField;
	}

	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	public String getDisplayField() {
		return this.displayField;
	}

	public void setDisplayField(String displayField) {
		this.displayField = displayField;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
