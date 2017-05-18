package com.free.studio.framework.core.utils;

import java.sql.Timestamp;

/**
 * @Title: DateUtil.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:18:32
 * @version V1.0
 */
public class DateUtil {
	public static java.sql.Date currentSqlDate() {
		return new java.sql.Date(System.currentTimeMillis());
	}

	public static java.util.Date currentDate() {
		return new java.util.Date(System.currentTimeMillis());
	}

	public static Timestamp currentTime() {
		return new Timestamp(System.currentTimeMillis());
	}
}
