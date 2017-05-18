package com.free.studio.framework.core.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

/**
 * @Title: UtilDateConverter.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:22:17
 * @version V1.0
 */
public class UtilDateConverter implements Converter {
	public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:Ss.0");
	private Object defaultValue = null;
	private boolean useDefault = true;

	public UtilDateConverter() {
		this.defaultValue = null;
		this.useDefault = true;
		this.defaultValue = null;
		this.useDefault = false;
	}

	public UtilDateConverter(Object defaultValue) {
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
			if ((value instanceof Date)) {
				return value;
			}
			String s = value.toString();
			if (s.matches("\\d+")) {
				return new Date(Long.parseLong(s));
			}
			if (s.matches("[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-6][0-9]:[0-6][0-9]:[0-6][0-9]")) {
				return dateTimeFormat.parse(s);
			}
			if (s.matches("[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2} [0-6][0-9]:[0-6][0-9]:[0-6][0-9]\\.0")) {
				return timestampFormat.parse(s);
			}
			if (s.matches("[0-9]{1,4}-[0-9]{1,2}-[0-9]{1,2}")) {
				return dateFormat.parse(s);
			}
			return new Date(value.toString());
		} catch (Exception e) {
			if (this.useDefault) {
				return this.defaultValue;
			}
			throw new ConversionException(e);
		}
	}
}
