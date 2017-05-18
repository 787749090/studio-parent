package com.free.studio.framework.pureui.controllers;

import com.free.studio.framework.core.support.controllers.ActionSupport;
import com.free.studio.framework.pureui.view.JSONMessage;

/**
 * @Title: JSONActionSupport.java
 * @Package com.free.studio.framework.pureui.controllers
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:27:30
 * @version V1.0
 */
public class JSONActionSupport extends ActionSupport {

	protected JSONMessage jsonMessage;

	public JSONMessage getJsonMessage() {
		return this.jsonMessage;
	}

	public void setJsonMessage(JSONMessage jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

}
