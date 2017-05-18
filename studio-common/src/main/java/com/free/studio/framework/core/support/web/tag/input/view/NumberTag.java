package com.free.studio.framework.core.support.web.tag.input.view;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import com.free.studio.framework.core.support.web.tag.input.attribute.Number;
/**
 * @Title: NumberTag.java
 * @Package com.free.studio.framework.core.support.web.tag.input.view
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:04:31
 * @version V1.0
 */
public abstract class NumberTag extends Number {

	public void doTag() throws JspException, IOException {
		getJspContext().getOut().write("<input " + getTagAttribute() + "/>");
		super.doTag();
	}
}
