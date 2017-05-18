package com.free.studio.framework.core.support.web.tag.input.attribute;

/**
 * @Title: Number.java
 * @Package com.free.studio.framework.core.support.web.tag.input.attribute
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:02:51
 * @version V1.0
 */
public class Number extends CommonAttribute {

	public String getTagAttribute() {
		StringBuffer attribute = new StringBuffer();
		attribute.append(getCommonAttribute());
		attribute.append("controltype='number' ");
		return attribute.toString();
	}
}
