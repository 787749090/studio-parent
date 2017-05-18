package com.free.studio.framework.core.enhanced;

import java.io.Writer;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @Title: JSONResult.java
 * @Package com.free.studio.framework.core.enhanced
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:24:08
 * @version V1.0
 */
public abstract class JSONResult implements Result {
	private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final String DEFAULT_CONTENTTYPE = "text/html";
	private String root;
	private String format = "yyyy-MM-dd";
	private String contentType = "text/html";
	private String charset = "UTF-8";

	public void execute(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();

		HttpServletResponse response = (HttpServletResponse) actionContext
				.get("com.opensymphony.xwork2.dispatcher.HttpServletResponse");
		Object object = findRootObject(invocation);
		SerializeConfig config = new SerializeConfig();

		config.put(Date.class, new SimpleDateFormatSerializer(this.format));
		String json = JSON.toJSONString(object, config, new SerializerFeature[0]);
		response.setContentType(this.contentType);
		response.setCharacterEncoding(this.charset);
		Writer writer = response.getWriter();
		writer.write(json);
		writer.flush();
	}

	private Object findRootObject(ActionInvocation invocation) {
		Object rootObject;
		if (this.root != null) {
			ValueStack stack = invocation.getStack();
			rootObject = stack.findValue(this.root);
		} else {
			rootObject = invocation.getStack().peek();
		}
		return rootObject;
	}

	public String getRoot() {
		return this.root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getContentType() {
		return this.contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getCharset() {
		return this.charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}
}
