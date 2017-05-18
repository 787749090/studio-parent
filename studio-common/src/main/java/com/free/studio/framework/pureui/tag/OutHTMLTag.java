package com.free.studio.framework.pureui.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

/**
 * @Title: OutHTMLTag.java
 * @Package com.free.studio.framework.pureui.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:32:41
 * @version V1.0
 */
public class OutHTMLTag extends BodyTagSupport {

	private static final long serialVersionUID = 9007072430282797853L;

	public int doEndTag() throws JspException {
		Tag parent;
		if (!((parent = getParent()) instanceof SelectTag)) {
			throw new JspTagException("Illegal use of <outHTML>-style tag without <select> as its direct parent");
		}
		if ((null != this.bodyContent) && (null != this.bodyContent.getString())
				&& (!"".equals(this.bodyContent.getString().trim()))) {
			((SelectTag) parent).appendSelfHTML(this.bodyContent.getString().trim());
		}
		return 6;
	}
}
