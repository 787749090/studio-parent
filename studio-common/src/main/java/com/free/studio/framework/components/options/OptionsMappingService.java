package com.free.studio.framework.components.options;

import java.util.Collection;
import java.util.Locale;

/**
 * @Title: OptionsMappingService.java
 * @Package com.free.studio.framework.components.options
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:48:49
 * @version V1.0
 */
public interface OptionsMappingService {
	public abstract void convert(Object paramObject, Mapping[] paramArrayOfMapping, Locale paramLocale);

	public abstract void convert(Object paramObject, Mapping[] paramArrayOfMapping);

	public abstract void convertBeans(Collection paramCollection, Mapping[] paramArrayOfMapping, Locale paramLocale);

	public abstract void convertBeans(Collection paramCollection, Mapping[] paramArrayOfMapping);

	public abstract void convertBeans(Object[] paramArrayOfObject, Mapping[] paramArrayOfMapping, Locale paramLocale);

	public abstract void convertBeans(Object[] paramArrayOfObject, Mapping[] paramArrayOfMapping);
}
