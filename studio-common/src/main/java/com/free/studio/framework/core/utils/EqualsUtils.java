package com.free.studio.framework.core.utils;

/**
 * @Title: EqualsUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:19:01
 * @version V1.0
 */
public class EqualsUtils {
	public static boolean isEquals(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}
		return str1.equals(str2);
	}

	public static boolean isEquals(Integer int1, Integer int2) {
		if (int1 == null) {
			return int2 == null;
		}
		return int1.equals(int2);
	}

	public static boolean isEquals(Double d1, Double d2) {
		if (null == d1) {
			return d2 == null;
		}
		return d1.equals(d2);
	}

	public static boolean isLess(Double d1, Double d2) {
		if (null == d1) {
			d1 = new Double(0.0D);
		}
		if (null == d2) {
			d2 = new Double(0.0D);
		}
		return d1.doubleValue() < d2.doubleValue();
	}
}
