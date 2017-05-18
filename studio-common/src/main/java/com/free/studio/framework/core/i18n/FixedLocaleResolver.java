package com.free.studio.framework.core.i18n;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;

/**
 * @Title: FixedLocaleResolver.java
 * @Package com.free.studio.framework.core.i18n
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:31:34
 * @version V1.0
 */
public class FixedLocaleResolver implements LocaleResolver {
	private Locale fixedLoacle = Locale.CHINA;

	public Locale resolveLocale(HttpServletRequest httpservletrequest) {
		return this.fixedLoacle;
	}

	public void setLocale(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse,
			Locale locale) {
	}

	public Locale getFixedLoacle() {
		return this.fixedLoacle;
	}

	public void setFixedLoacle(Locale fixedLoacle) {
		this.fixedLoacle = fixedLoacle;
	}
}
