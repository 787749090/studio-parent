package com.free.studio.framework.components.options.impl;

import java.util.Locale;

import org.springframework.beans.factory.InitializingBean;

import com.free.studio.framework.components.options.OptionGroup;
import com.free.studio.framework.components.options.OptionItem;
import com.free.studio.framework.components.options.OptionsSource;

/**
 * @Title: ConstantOptionsSource.java
 * @Package com.free.studio.framework.components.options.impl
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:50:24
 * @version V1.0
 */
public class ConstantOptionsSource implements OptionsSource, InitializingBean {
	private String type;
	protected OptionItem[] items;
	protected OptionGroup optionGroup;

	public void afterPropertiesSet() throws Exception {
		this.optionGroup = new OptionGroup();
		this.optionGroup.setItems(this.items);
	}

	public OptionItem getOption(Object key, Locale locale) {
		return this.optionGroup.getItem(key);
	}

	public String getOptionType() {
		return this.type;
	}

	public OptionGroup getOptions(Locale locale) {
		return this.optionGroup;
	}

	public OptionItem[] getItems() {
		return this.items;
	}

	public void setItems(OptionItem[] items) {
		this.items = items;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
