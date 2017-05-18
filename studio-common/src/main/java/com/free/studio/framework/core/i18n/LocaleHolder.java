package com.free.studio.framework.core.i18n;

import java.util.Locale;

/**
 * @Title: LocaleHolder.java
 * @Package com.free.studio.framework.core.i18n
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:32:12
 * @version V1.0
 */
public class LocaleHolder {
	private static final ThreadLocal<Locale> catchLocale = new ThreadLocal();
	private static Locale defaultLoadle = Locale.CHINESE;

	public static Locale getLocale() {
		Locale locale = (Locale) catchLocale.get();
		return locale == null ? defaultLoadle : locale;
	}

	public static void setLocale(Locale locale) {
		catchLocale.set(locale);
	}
}
