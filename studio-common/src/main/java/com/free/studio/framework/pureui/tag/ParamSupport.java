package com.free.studio.framework.pureui.tag;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;
import org.apache.taglibs.standard.resources.Resources;

import org.apache.taglibs.standard.tag.common.core.ParamParent;

/**
 * @Title: ParamSupport.java
 * @Package com.free.studio.framework.pureui.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:33:12
 * @version V1.0
 */
public class ParamSupport extends BodyTagSupport {

	protected String name;
	protected String value;

	public ParamSupport() {
		init();
	}

	private void init() {
		this.name = (this.value = null);
	}

	public int doEndTag() throws JspException {
		Tag t = findAncestorWithClass(this, ParamParent.class);
		if (t == null) {
			throw new JspTagException(Resources.getMessage("PARAM_OUTSIDE_PARENT"));
		}
		if ((this.name == null) || (this.name.equals(""))) {
			return 6;
		}
		ParamParent parent = (ParamParent) t;
		String value = this.value;
		if (value == null) {
			if ((this.bodyContent == null) || (this.bodyContent.getString() == null)) {
				value = "";
			} else {
				value = this.bodyContent.getString().trim();
			}
		}
		parent.addParameter(this.name, value);
		return 6;
	}

	public void release() {
		init();
	}

	public static class ParamManager {
		private List<String> names = new LinkedList();
		private List<String> values = new LinkedList();
		private boolean done = false;

		public void addParameter(String name, String value) {
			if (this.done) {
				throw new IllegalStateException();
			}
			if (name != null) {
				this.names.add(name);
				if (value != null) {
					this.values.add(value);
				} else {
					this.values.add("");
				}
			}
		}
	}
}
