package com.free.studio.framework.components.options.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.InitializingBean;

import com.free.studio.framework.components.options.Mapping;
import com.free.studio.framework.components.options.OptionGroup;
import com.free.studio.framework.components.options.OptionItem;
import com.free.studio.framework.components.options.OptionsFactory;
import com.free.studio.framework.components.options.OptionsMappingService;
import com.free.studio.framework.components.options.OptionsSource;
import com.free.studio.framework.components.options.exception.MappingNotFoundException;
import com.free.studio.framework.core.i18n.LocaleHolder;

/**
 * @Title: OptionsRegistry.java
 * @Package com.free.studio.framework.components.options.impl
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:51:17
 * @version V1.0
 */
public class OptionsRegistry implements OptionsFactory, OptionsMappingService, InitializingBean {
	private boolean throwExceptionWhenNotMapping = false;
	private boolean useKeyValueWhenNotMapping = false;
	private Set<? extends OptionsSource> optionsSources;
	private Map<String, Object> sourcesMap;

	protected Locale getDefaultLoacle() {
		return LocaleHolder.getLocale();
	}

	private OptionsSource getOptionsSource(String type) {
		Object os = this.sourcesMap.get(type);
		if ((os == null) || (!(os instanceof OptionsSource))) {
			try {
				throw new Exception(type);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return (OptionsSource) os;
	}

	public void afterPropertiesSet() throws Exception {
		if (this.optionsSources != null) {
			this.sourcesMap = new HashMap();
			for (OptionsSource src : this.optionsSources) {
				this.sourcesMap.put(src.getOptionType(), src);
			}
			this.optionsSources = null;
		}
	}

	public OptionItem getOption(String type, Object key) {
		return getOption(type, key, getDefaultLoacle());
	}

	public OptionGroup getOptions(String type) {
		return getOptions(type, getDefaultLoacle());
	}

	public OptionItem getOption(String type, Object key, Locale locale) {
		return getOptionsSource(type).getOption(key, locale);
	}

	public OptionGroup getOptions(String type, Locale locale) {
		return getOptionsSource(type).getOptions(locale);
	}

	public void convert(Object bean, Mapping[] mappings, Locale locale) {
		if ((mappings == null) || (mappings.length < 1)) {
			return;
		}
		BeanWrapper wrapper = new BeanWrapperImpl(bean);
		for (int i = 0; i < mappings.length; i++) {
			Mapping mapping = mappings[i];
			Object val = wrapper.getPropertyValue(mapping.getValueField());
			OptionItem pi = getOption(mapping.getType(), val, locale);
			if (pi != null) {
				wrapper.setPropertyValue(mapping.getDisplayField(), pi.getValue());
			} else if (this.useKeyValueWhenNotMapping == true) {
				wrapper.setPropertyValue(mapping.getDisplayField(), val);
			} else if (this.throwExceptionWhenNotMapping == true) {
				throw new MappingNotFoundException(mapping.getType(), val);
			}
		}
	}

	public void convert(Object bean, Mapping[] mappings) {
		convert(bean, mappings, getDefaultLoacle());
	}

	public void convertBeans(Collection beans, Mapping[] mappings, Locale locale) {
		if ((mappings == null) || (mappings.length < 1) || (beans == null) || (beans.size() < 1)) {
			return;
		}
		for (Iterator iter = beans.iterator(); iter.hasNext();) {
			Object bean = iter.next();
			convert(bean, mappings, locale);
		}
	}

	public void convertBeans(Collection beans, Mapping[] mappings) {
		convertBeans(beans, mappings, getDefaultLoacle());
	}

	public void convertBeans(Object[] beans, Mapping[] mappings, Locale locale) {
		if ((mappings == null) || (mappings.length < 1) || (beans == null) || (beans.length < 1)) {
			return;
		}
		for (int i = 0; i < beans.length; i++) {
			convert(beans[i], mappings, locale);
		}
	}

	public void convertBeans(Object[] beans, Mapping[] mappings) {
		convertBeans(beans, mappings, getDefaultLoacle());
	}

	public void setOptionsSources(Set<? extends OptionsSource> optionsSources) {
		this.optionsSources = optionsSources;
	}

	public boolean isThrowExceptionWhenNotMapping() {
		return this.throwExceptionWhenNotMapping;
	}

	public void setThrowExceptionWhenNotMapping(boolean throwExceptionWhenNotMapping) {
		this.throwExceptionWhenNotMapping = throwExceptionWhenNotMapping;
	}

	public boolean isUseKeyValueWhenNotMapping() {
		return this.useKeyValueWhenNotMapping;
	}

	public void setUseKeyValueWhenNotMapping(boolean useKeyValueWhenNotMapping) {
		this.useKeyValueWhenNotMapping = useKeyValueWhenNotMapping;
	}
}
