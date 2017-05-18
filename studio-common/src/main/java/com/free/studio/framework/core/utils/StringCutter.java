package com.free.studio.framework.core.utils;

/**
 * @Title: StringCutter.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:21:46
 * @version V1.0
 */
public class StringCutter {
	public static final String cutString(String str, Integer maxLength, String ellipsis) {
		if (str == null) {
			return "";
		}
		byte[] strByte = str.getBytes();
		int strLen = strByte.length;
		int elideLen = ellipsis.length() == 0 ? 0 : ellipsis.getBytes().length;
		if ((maxLength.intValue() >= strLen) || (maxLength.intValue() < 1)) {
			return str;
		}
		if (maxLength.intValue() - elideLen > 0) {
			maxLength = Integer.valueOf(maxLength.intValue() - elideLen);
		}
		int count = 0;
		for (int i = 0; i < maxLength.intValue(); i++) {
			int value = strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			maxLength = Integer
					.valueOf(maxLength.intValue() == 1 ? maxLength.intValue() + 1 : maxLength.intValue() - 1);
		}
		return new String(strByte, 0, maxLength.intValue()) + ellipsis;
	}

	public static void main(String[] args) throws Exception {
	}
}
