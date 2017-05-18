package com.free.studio.framework.components.options;

import java.io.Serializable;

/**
 * @Title: OptionGroup.java
 * @Package com.free.studio.framework.components.options
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:48:00
 * @version V1.0
 */
public class OptionGroup implements Serializable {
	private OptionItem[] items;

	public OptionItem[] getItems() {
		return this.items;
	}

	public void setItems(OptionItem[] items) {
		this.items = items;
	}

	public int size() {
		return this.items == null ? 0 : this.items.length;
	}

	public OptionItem getItem(Object key) {
		if (this.items != null) {
			for (int i = 0; i < this.items.length; i++) {
				if (this.items[i].getKey().equals(key)) {
					return this.items[i];
				}
			}
		}
		return null;
	}
}
