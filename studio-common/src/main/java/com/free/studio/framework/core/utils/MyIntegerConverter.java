package com.free.studio.framework.core.utils;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * @Title: MyIntegerConverter.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:20:21
 * @version V1.0
 */
public class MyIntegerConverter implements Converter {
	private Object defaultValue = null;
	private boolean useDefault = true;

	public MyIntegerConverter() {
		this.defaultValue = null;
		this.useDefault = true;
		this.defaultValue = null;
		this.useDefault = false;
	}

	public MyIntegerConverter(Object defaultValue) {
		this.defaultValue = null;
		this.useDefault = true;
		this.defaultValue = defaultValue;
		this.useDefault = true;
	}

	public Object convert(Class type, Object value) {
		try {
			if (value == null) {
				return null;
			}
			if ((value instanceof Integer)) {
				return value;
			}
			if ((value instanceof Number)) {
				return new Integer(((Number) value).intValue());
			}
			return new Integer(value.toString());
		} catch (Exception e) {
			if (this.useDefault) {
				return this.defaultValue;
			}
			throw new ConversionException(e);
		}
	}
}
