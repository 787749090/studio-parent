package com.free.studio.framework.components.options.impl;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.free.studio.framework.components.options.OptionGroup;
import com.free.studio.framework.components.options.OptionItem;

/**
 * @Title: I18nConstantOptionsSource.java
 * @Package com.free.studio.framework.components.options.impl
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:50:57
 * @version V1.0
 */
public class I18nConstantOptionsSource extends ConstantOptionsSource implements ApplicationContextAware {
	private ApplicationContext context = null;

	public OptionItem getOption(Object key, Locale locale) {
		OptionItem item = this.optionGroup.getItem(key);
		return newI18nItem(item, locale);
	}

	public OptionGroup getOptions(Locale locale) {
		OptionItem[] newItems = new OptionItem[this.items.length];
		for (int i = 0; i < this.items.length; i++) {
			newItems[i] = newI18nItem(this.items[i], locale);
		}
		OptionGroup group = new OptionGroup();
		group.setItems(newItems);
		return group;
	}

	protected OptionItem newI18nItem(OptionItem item, Locale locale) {
		OptionItem newItem = new OptionItem();
		newItem.setKey(item.getKey());

		newItem.setValue(getMessage(item.getValue(), locale));
		return newItem;
	}

	protected String getMessage(Object key, Locale locale) {
		return this.context.getMessage((String) key, null, locale);
	}

	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.context = ctx;
	}
}
