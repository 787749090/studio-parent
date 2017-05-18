package com.free.studio.framework.components.options;

import java.util.Locale;

/**
 * @Title: OptionsFactory.java
 * @Package com.free.studio.framework.components.options
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:48:30
 * @version V1.0
 */
public interface OptionsFactory {
	public abstract OptionItem getOption(String paramString, Object paramObject);

	public abstract OptionItem getOption(String paramString, Object paramObject, Locale paramLocale);

	public abstract OptionGroup getOptions(String paramString, Locale paramLocale);

	public abstract OptionGroup getOptions(String paramString);
}
