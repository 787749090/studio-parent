package com.free.studio.framework.components.webservice;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.transport.http.XFireServletController;

/**
 * @Title: MyXFireServletController.java
 * @Package com.free.studio.framework.components.webservice
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午3:02:20
 * @version V1.0
 */
public class MyXFireServletController extends XFireServletController {
	public MyXFireServletController(XFire xfire, ServletContext servletContext) {
		super(xfire, servletContext);
	}

	public MyXFireServletController(XFire xfire) {
		super(xfire);
	}

	protected String getService(HttpServletRequest request) {
		String uri = request.getRequestURI();
		int index = uri.lastIndexOf("/");
		return uri.substring(index + 1);
	}
}
