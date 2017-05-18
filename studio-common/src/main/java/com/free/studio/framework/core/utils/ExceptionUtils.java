package com.free.studio.framework.core.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

/**
 * @Title: ExceptionUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:19:17
 * @version V1.0
 */
public class ExceptionUtils {
	public static Throwable getRootException(Throwable e) {
		if (e != null) {
			Set<Throwable> set = new HashSet();
			Throwable cause = e.getCause();
			while ((cause != null) && (cause.getCause() != null) && (!set.contains(cause))) {
				set.add(cause);
				cause = cause.getCause();
			}
			return cause;
		}
		return null;
	}

	public static String getRootMessage(Throwable e) {
		Throwable cause = getRootException(e);
		return cause == null ? null : cause.getMessage();
	}

	public static String getStackTrace(Throwable e) {
		StringWriter out = new StringWriter();
		getStackTrace(e, out);
		return out.toString();
	}

	public static void getStackTrace(Throwable e, Writer out) {
		e.printStackTrace(new PrintWriter(out));
	}
}
