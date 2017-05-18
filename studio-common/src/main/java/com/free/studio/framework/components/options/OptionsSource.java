package com.free.studio.framework.components.options;

import java.util.Locale;

/**
 * @Title: OptionsSource.java
 * @Package com.free.studio.framework.components.options
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:49:07
 * @version V1.0
 */
public interface OptionsSource {
	public abstract OptionGroup getOptions(Locale paramLocale);

	public abstract OptionItem getOption(Object paramObject, Locale paramLocale);

	public abstract String getOptionType();
}
