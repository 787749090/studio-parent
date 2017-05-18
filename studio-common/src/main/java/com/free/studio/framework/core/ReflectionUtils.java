package com.free.studio.framework.core;

import java.lang.reflect.Field;

/**
 * @Title: ReflectionUtils.java
 * @Package com.free.studio.framework.core
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:30:51
 * @version V1.0
 */
public class ReflectionUtils {
	public static void setFieldQuietly(Class clazz, Object obj, String fieldName, Object value) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
		}
	}

	public static void setFieldQuietly(Object obj, String fieldName, Object value) {
		Class clazz = obj.getClass();
		try {
			Field field = clazz.getField(fieldName);
			field.setAccessible(true);
			field.set(obj, value);
		} catch (Exception e) {
		}
	}
}
