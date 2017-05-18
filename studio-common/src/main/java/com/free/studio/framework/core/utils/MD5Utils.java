package com.free.studio.framework.core.utils;

import java.security.MessageDigest;

/**
 * @Title: MD5Utils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:19:47
 * @version V1.0
 */
public class MD5Utils {
	public static final String encode(String s) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char[] str = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
				str[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			String str1 = new String(str);
			String str2 = new String();
			for (int i = 8; i < 24; i++) {
				str2 = str2 + str1.charAt(i);
			}
			return str2;
		} catch (Exception e) {
		}
		return null;
	}
}
