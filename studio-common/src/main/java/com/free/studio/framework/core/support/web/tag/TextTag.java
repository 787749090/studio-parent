package com.free.studio.framework.core.support.web.tag;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.NoSuchMessageException;
import org.springframework.util.StringUtils;

import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.i18n.LocaleHolder;
import com.free.studio.framework.core.utils.ContextUtils;
import com.free.studio.framework.core.utils.StringCutter;

/**
 * @Title: TextTag.java
 * @Package com.free.studio.framework.core.support.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:01:11
 * @version V1.0
 */
public class TextTag extends TagSupport {

	private static final String I18N_PREFIX = "ui.";
	private static final String DEFAULT_ARGUMENT_SEPARATOR = ",";
	private String text;
	private String argumentSeparator = ",";
	private Object arguments;
	private int displaySize = -1;
	private String omit = "...";

	public int doStartTag() throws JspException {
		try {
			ApplicationContext ctx = getApplicationContext();

			Object[] args = resolveArguments(this.arguments);
			printText(ctx.getMessage(this.text, args, LocaleHolder.getLocale()));
		} catch (NoSuchMessageException e) {
			try {
				printText(this.text);
			} catch (IOException e1) {
			}
		} catch (IOException e) {
			throw new JspException(e.getMessage(), e);
		}
		return 0;
	}

	protected ApplicationContext getApplicationContext() {
		if (this.text.startsWith("ui.")) {
			int beginIndex = "ui.".length();
			int endIndex = this.text.indexOf(".", beginIndex);
			String module = this.text.substring(beginIndex, endIndex);
			return ContextManager.getModuleContext(module);
		}
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		return ContextUtils.getContext(request);
	}

	public int doEndTag() throws JspException {
		return 6;
	}

	private void printText(String textStr) throws IOException {
		if (this.displaySize > 0) {
			textStr = StringCutter.cutString(textStr, Integer.valueOf(this.displaySize), this.omit);
		}
		JspWriter out = this.pageContext.getOut();
		out.print(textStr);
	}

	protected Object[] resolveArguments(Object arguments) throws JspException {
		if ((arguments instanceof String)) {
			String[] stringArray = StringUtils.delimitedListToStringArray((String) arguments, this.argumentSeparator);
			return stringArray;
		}
		if ((arguments instanceof Object[])) {
			return (Object[]) arguments;
		}
		if ((arguments instanceof Collection)) {
			return ((Collection) arguments).toArray();
		}
		if (arguments != null) {
			return new Object[] { arguments };
		}
		return null;
	}

	public void release() {
		super.release();
		this.text = null;
		this.arguments = null;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getArgumentSeparator() {
		return this.argumentSeparator;
	}

	public void setArgumentSeparator(String argumentSeparator) {
		this.argumentSeparator = argumentSeparator;
	}

	public Object getArguments() {
		return this.arguments;
	}

	public void setArguments(Object arguments) {
		this.arguments = arguments;
	}

	public int getDisplaySize() {
		return this.displaySize;
	}

	public void setDisplaySize(int displaySize) {
		this.displaySize = displaySize;
	}

	public String getOmit() {
		return this.omit;
	}

	public void setOmit(String omit) {
		this.omit = omit;
	}
}
