package com.free.studio.framework.core.support.web.tag;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.free.studio.framework.core.components.buitin.template.TemplateService;
import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.utils.EmptyUtils;

/**
 * @Title: Select.java
 * @Package com.free.studio.framework.core.support.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:00:41
 * @version V1.0
 */
public class Select extends TagSupport {

	private static final long serialVersionUID = -6042770121810655079L;
	private String keyName;
	private String valueName;
	private Object data;
	private String value;
	private String cssClass;
	private String name;
	private String readonly;
	private String id;
	private String querycondition;
	private String callbackFunction;
	private Object keyNow = "";
	private Object valueNow = "";
	private static Integer ICON_HEIGHT = Integer.valueOf(25);
	private static Integer ICON_DEFAULT_COUNT = Integer.valueOf(4);

	public int doStartTag() throws JspException {
		TemplateService templateService = (TemplateService) ContextManager.getRootContext()
				.getBean(TemplateService.class);
		JspWriter out = this.pageContext.getOut();
		getValueByKeyInData(this.data);
		Map context = buildContext();
		templateService.compile(out, "support/tags/select.html", context);
		return 0;
	}

	public int doEndTag() throws JspException {
		return 6;
	}

	public void release() {
		super.release();
	}

	private Map buildContext() {
		Map context = new HashMap();
		context.put("selectData", this.data);
		context.put("cssClass", this.cssClass);
		context.put("keyNow", this.keyNow);
		context.put("name", this.name);
		context.put("valueNow", this.valueNow);
		context.put("keyName", this.keyName);
		context.put("valueName", this.valueName);
		context.put("querycondition", this.querycondition);
		context.put("id", this.id);
		context.put("readonly", this.readonly);
		if (EmptyUtils.isEmpty(this.callbackFunction)) {
			this.callbackFunction = "null";
		}
		context.put("selectedCallbackFunction", this.callbackFunction);
		return context;
	}

	private int getValueByKeyInData(Object data) {
		this.keyNow = "";
		this.valueNow = "";
		Object[] dataObjs = null;
		List<Object> dataLists = null;
		if ((data instanceof Object[])) {
			dataObjs = (Object[]) data;
			arrayDataOper(dataObjs);
			return dataObjs.length;
		}
		if ((data instanceof List)) {
			dataLists = (List) data;
			listDataOper(dataLists);
			return dataLists.size();
		}
		return -1;
	}

	private void listDataOper(List<Object> dataLists) {
		for (Object obj : dataLists) {
			setBufferInLoop(obj);
		}
	}

	private void arrayDataOper(Object[] dataObjs) {
		for (Object obj : dataObjs) {
			setBufferInLoop(obj);
		}
	}

	private void setBufferInLoop(Object obj) {
		Object objKey = getValueByName(obj, this.keyName);
		Object objValue = getValueByName(obj, this.valueName);
		if ((EmptyUtils.isNotEmpty(this.value)) && (this.value.equals(objKey))) {
			this.keyNow = objKey;
			this.valueNow = objValue;
			return;
		}
	}

	private static Object getValueByName(Object obj, String paramName) {
		Field[] fields = obj.getClass().getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			if (f.getName().equals(paramName)) {
				try {
					return f.get(obj);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
			f.setAccessible(false);
		}
		return null;
	}

	public String getKeyName() {
		return this.keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getValueName() {
		return this.valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCssClass() {
		return this.cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReadonly() {
		return this.readonly.toLowerCase();
	}

	public void setReadonly(String readonly) {
		this.readonly = readonly;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuerycondition() {
		return this.querycondition;
	}

	public void setQuerycondition(String querycondition) {
		this.querycondition = querycondition;
	}

	public String getCallbackFunction() {
		return this.callbackFunction;
	}

	public void setCallbackFunction(String callbackFunction) {
		this.callbackFunction = callbackFunction;
	}
}
