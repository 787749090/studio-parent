package com.free.studio.framework.core.utils;

/**
 * @Title: StringUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:22:01
 * @version V1.0
 */
public class StringUtils {
	public static int getFullWidthLength(String str) {
		char[] ch = str.toCharArray();
		int len = 0;
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			len++;
			if (isChinese(c)) {
				len++;
			}
		}
		return len;
	}

	public static boolean isChinese(char c) {
		Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
		if ((ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS)
				|| (ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS)
				|| (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A)
				|| (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION)
				|| (ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION)
				|| (ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS)) {
			return true;
		}
		return false;
	}

	public static boolean hasChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		String str = "中国人";
		int len = getFullWidthLength(str);
		System.out.println("len=" + len);
	}
}
