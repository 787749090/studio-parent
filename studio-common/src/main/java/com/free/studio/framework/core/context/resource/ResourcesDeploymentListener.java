package com.free.studio.framework.core.context.resource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.free.studio.framework.core.context.archives.SupportDeploymentArchives;

/**
 * @Title: ResourcesDeploymentListener.java
 * @Package com.free.studio.framework.core.context.resource
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:21:55
 * @version V1.0
 */
public class ResourcesDeploymentListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent event) {
	}

	public void contextInitialized(ServletContextEvent event) {
		new SupportDeploymentArchives().scanArchives().deployArchives(getWebRootPath(event.getServletContext()));
	}

	private String getWebRootPath(ServletContext context) {
		String webroot = context.getRealPath("/");

		webroot = webroot.replaceAll("\\\\", "/");
		return webroot;
	}
}
