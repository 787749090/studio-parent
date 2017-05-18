package com.free.studio.framework.pureui.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.tag.common.core.ParamParent;

import com.free.studio.framework.components.options.OptionItem;
import com.free.studio.framework.components.options.OptionsFactory;
import com.free.studio.framework.core.utils.ContextUtils;

/**
 * @Title: SelectTag.java
 * @Package com.free.studio.framework.pureui.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:34:08
 * @version V1.0
 */
public class SelectTag extends BodyTagSupport implements ParamParent {

	private static final long serialVersionUID = -636897446484388555L;
	private String optionsType;
	private String value;
	private String name;
	private String cssClass;
	private StringBuffer selfHTML;
	private ParamSupport.ParamManager params;

	public int doStartTag() throws JspException {
		this.params = new ParamSupport.ParamManager();
		this.selfHTML = new StringBuffer();
		return 2;
	}

	public void addParameter(String name, String value) {
		this.params.addParameter(name, value);
	}

	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();

		OptionsFactory optionsFactory = (OptionsFactory) ContextUtils
				.getContext((HttpServletRequest) this.pageContext.getRequest()).getBean(OptionsFactory.class);

		OptionItem[] items = optionsFactory.getOptions(this.optionsType).getItems();
		StringBuffer sltStr = new StringBuffer();
		sltStr.append("<select");
		sltStr.append(" name=\"" + this.name + "\"");
		sltStr.append(" class=\"" + this.cssClass + "\"");
		sltStr.append(this.selfHTML);
		sltStr.append(">");
		for (OptionItem item : items) {
			sltStr.append("<option value=\"");
			sltStr.append(item.getKey());
			sltStr.append('"');
			sltStr.append(item.getKey().equals(this.value) ? " selected" : "");
			sltStr.append('>');
			sltStr.append(item.getValue());
			sltStr.append("</option>");
		}
		sltStr.append("</select>");
		try {
			out.print(sltStr);
		} catch (IOException e) {
		}
		return 6;
	}

	public void release() {
		super.release();
		this.optionsType = null;
		this.value = null;
		this.name = null;
		this.cssClass = null;
		this.selfHTML = null;
	}

	public void setOptionsType(String optionsType) {
		this.optionsType = optionsType;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public void appendSelfHTML(String selfHTML) {
		this.selfHTML.append(' ').append(selfHTML);
	}
}
