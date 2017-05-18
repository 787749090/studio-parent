package com.free.studio.framework.core.i18n;

import java.util.Locale;

import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.utils.ContextUtils;
import com.free.studio.framework.core.web.HttpRequestHolder;

/**
 * @Title: I18nUtils.java
 * @Package com.free.studio.framework.core.i18n
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:31:52
 * @version V1.0
 */
public class I18nUtils {
	public static Locale getLocale() {
		return LocaleHolder.getLocale();
	}

	public static String getRequestText(String key) {
		ApplicationContext context = ContextUtils.getContext(HttpRequestHolder.getRequest());
		return context.getMessage(key, new Object[0], LocaleHolder.getLocale());
	}

	public static String getRequestText(String key, Object param) {
		ApplicationContext context = ContextUtils.getContext(HttpRequestHolder.getRequest());
		return context.getMessage(key, new Object[] { param }, LocaleHolder.getLocale());
	}

	public static String getRequestText(String key, Object[] params) {
		ApplicationContext context = ContextUtils.getContext(HttpRequestHolder.getRequest());
		return context.getMessage(key, params, LocaleHolder.getLocale());
	}

	public static String getText(ApplicationContext context, String key, Object param) {
		return context.getMessage(key, new Object[] { param }, LocaleHolder.getLocale());
	}

	public static String getText(ApplicationContext context, String key) {
		return context.getMessage(key, new Object[0], LocaleHolder.getLocale());
	}

	public static String getText(ApplicationContext context, String key, Object[] params) {
		return context.getMessage(key, params, LocaleHolder.getLocale());
	}
}
