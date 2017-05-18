package com.free.studio.framework.core.support.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * @Title: ControllerTag.java
 * @Package com.free.studio.framework.core.support.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:59:27
 * @version V1.0
 */
public class ControllerTag extends SimpleTagSupport {

	protected static String PAGER = "pager";
	static String NUMBER = "number";
	static String SELECT = "select";
	private static String TAG_SPLIT = ",";
	static String STYLE_IMPORT = "<link rel='stylesheet' type='text/css' href='";
	static String JS_IMPORT = "<script type='text/javascript' src='";
	private String basePath;
	private String tags;

	public void doTag() throws JspException, IOException {
		StringBuilder strB = new StringBuilder();
		if (isHaveTag(SELECT).booleanValue()) {
			strB.append(STYLE_IMPORT).append(this.basePath + "/common/style/select.css'/>");
		}
		if (isHaveTag(PAGER).booleanValue()) {
			strB.append(STYLE_IMPORT).append(this.basePath + "/common/style/Pager.css'/>");
		}
		getJspContext().getOut().write(strB.toString());
		super.doTag();
	}

	private Boolean isHaveTag(String tag) {
		String[] ctTags = this.tags.split(TAG_SPLIT);
		boolean bool = false;
		for (int i = 0; i < ctTags.length; i++) {
			bool = ctTags[i].equals(tag);
			if (bool) {
				return Boolean.valueOf(bool);
			}
		}
		return Boolean.valueOf(bool);
	}

	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getBasePath() {
		return this.basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
}
