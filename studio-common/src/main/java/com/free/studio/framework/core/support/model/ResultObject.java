package com.free.studio.framework.core.support.model;

import java.io.Serializable;

/**
 * @Title: ResultObject.java
 * @Package com.free.studio.framework.core.support.model
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:57:04
 * @version V1.0
 */
public class ResultObject implements Serializable {

	private static final long serialVersionUID = 1L;
	private boolean success;
	private Object data;
	private String message;

	public boolean isSuccess() {
		return this.success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
