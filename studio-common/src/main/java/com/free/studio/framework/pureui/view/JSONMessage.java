package com.free.studio.framework.pureui.view;

import java.io.Serializable;

/**
 * @Title: JSONMessage.java
 * @Package com.free.studio.framework.pureui.view
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:30:31
 * @version V1.0
 */
public class JSONMessage implements Serializable {

	private Boolean result;
	private Boolean exception;
	private String msg;
	private Serializable data;

	public Boolean getResult() {
		return this.result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Serializable getData() {
		return this.data;
	}

	public void setData(Serializable data) {
		this.data = data;
	}

	public Boolean getException() {
		return this.exception;
	}

	public void setException(Boolean exception) {
		this.exception = exception;
	}
}
