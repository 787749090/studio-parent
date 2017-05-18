package com.free.studio.framework.core.utils;

import java.sql.Timestamp;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * @Title: MySqlTimestampConverter.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:21:00
 * @version V1.0
 */
public class MySqlTimestampConverter implements Converter {
	private Object defaultValue = null;
	private boolean useDefault = true;

	public MySqlTimestampConverter() {
		this.defaultValue = null;
		this.useDefault = true;
		this.defaultValue = null;
		this.useDefault = false;
	}

	public MySqlTimestampConverter(Object defaultValue) {
		this.defaultValue = null;
		this.useDefault = true;
		this.defaultValue = defaultValue;
		this.useDefault = true;
	}

	public Object convert(Class type, Object value) {
		try {
			if (value == null) {
				if (this.useDefault) {
					return this.defaultValue;
				}
				throw new ConversionException("No value specified");
			}
			if ((value instanceof Timestamp)) {
				return value;
			}
			return Timestamp.valueOf(value.toString());
		} catch (Exception e) {
			if (this.useDefault) {
				return this.defaultValue;
			}
			throw new ConversionException(e);
		}
	}
}
