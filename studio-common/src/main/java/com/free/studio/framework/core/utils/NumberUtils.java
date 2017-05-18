package com.free.studio.framework.core.utils;

/**
 * @Title: NumberUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:21:19
 * @version V1.0
 */
public class NumberUtils {
	public static Double nullToZero(Double value) {
		return Double.valueOf(value == null ? 0.0D : value.doubleValue());
	}

	public static Integer nullToZero(Integer value) {
		return Integer.valueOf(value == null ? 0 : Integer.valueOf(value.intValue()).intValue());
	}

	public static Long nullToZero(Long value) {
		return Long.valueOf(value == null ? 0L : Long.valueOf(value.longValue()).longValue());
	}

	public static Double toDouble(String value) {
		return toDouble(value, true);
	}

	public static Double toDouble(String value, boolean nullToZero) {
		if (nullToZero) {
			return Double.valueOf(value == null ? 0.0D : Double.valueOf(value).doubleValue());
		}
		return value == null ? null : Double.valueOf(value);
	}

	public static Integer toInteger(String value) {
		return toInteger(value, true);
	}

	public static Integer toInteger(String value, boolean nullToZero) {
		if (nullToZero) {
			return Integer.valueOf(value == null ? 0 : Integer.valueOf(value).intValue());
		}
		return value == null ? null : Integer.valueOf(value);
	}

	public static Long toLong(String value) {
		return toLong(value, true);
	}

	public static Long toLong(String value, boolean nullToZero) {
		if (nullToZero) {
			return Long.valueOf(value == null ? 0L : Long.valueOf(value).longValue());
		}
		return value == null ? null : Long.valueOf(value);
	}
}
