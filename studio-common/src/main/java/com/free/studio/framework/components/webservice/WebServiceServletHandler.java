package com.free.studio.framework.components.webservice;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.xfire.XFire;
import org.codehaus.xfire.transport.Transport;
import org.codehaus.xfire.transport.http.XFireServletController;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;

import com.free.studio.framework.core.web.servlet.ServletHandler;

/**
 * @Title: WebServiceServletHandler.java
 * @Package com.free.studio.framework.components.webservice
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午3:02:39
 * @version V1.0
 */
public class WebServiceServletHandler implements ServletHandler, ApplicationContextAware {
	private static final String DEFAULT_WEBSERVICE_ROOT = "services";
	private String webServiceRoot = "services";
	private WebApplicationContext context;
	protected XFire xfire;
	protected XFireServletController controller;

	public XFire getXFire() throws ServletException {
		if (this.xfire == null) {
			this.xfire = createXFire();
		}
		return this.xfire;
	}

	public XFireServletController getController() throws ServletException {
		if (this.controller == null) {
			this.controller = createController();
		}
		return this.controller;
	}

	public XFire createXFire() throws ServletException {
		return (XFire) this.context.getBean(XFire.class);
	}

	public XFireServletController createController() throws ServletException {
		return new MyXFireServletController(getXFire(), this.context.getServletContext());
	}

	public void destroyXFire() {
		if (this.xfire != null) {
			Transport transport;
			for (Iterator iterator = this.xfire.getTransportManager().getTransports().iterator(); iterator
					.hasNext(); transport.dispose()) {
				transport = (Transport) iterator.next();
			}
		}
	}

	public String getWebServiceRoot() {
		return this.webServiceRoot;
	}

	public void setWebServiceRoot(String webServiceRoot) {
		this.webServiceRoot = webServiceRoot;
	}

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = ((WebApplicationContext) context);
	}

	public void destory() {
		destroyXFire();
		this.prefix = null;
	}

	public boolean handle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		getController().doService(request, response);
		return false;
	}

	private String prefix = null;

	public void init(ServletContext context) {
	}

	public boolean isQualified(HttpServletRequest request) {
		if (this.prefix == null) {
			String module = this.context.getId();
			this.prefix = (request.getContextPath() + "/" + module + "/" + this.webServiceRoot);
		}
		String uri = request.getRequestURI();
		return uri.startsWith(this.prefix);
	}
}
