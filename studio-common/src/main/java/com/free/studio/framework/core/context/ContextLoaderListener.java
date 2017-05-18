package com.free.studio.framework.core.context;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.free.studio.framework.core.context.archives.DeploymentArchive;
import com.free.studio.framework.core.context.archives.ModuleDeploymentArchives;
import com.free.studio.framework.core.context.archives.SupportDeploymentArchives;
import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: ContextLoaderListener.java
 * @Package com.free.studio.framework.core.context
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:15:36
 * @version V1.0
 */
public class ContextLoaderListener extends org.springframework.web.context.ContextLoaderListener {
	private static final Logger logger = LoggerFactory.getLogger(ContextLoaderListener.class);
	public static final String ROOT_CONTEXT_FILE_NAME = "root.xml";
	public static final String ROOT_CONTEXT_LOCATION = "classpath:framework/root.xml";
	private WebApplicationContext root = null;

	protected WebApplicationContext createWebApplicationContext(ServletContext sc) {
		WebApplicationContext wac = (XmlWebApplicationContext) super.createWebApplicationContext(sc);

		this.root = wac;
		ContextManager.setRootContext(this.root);
		if ((wac instanceof ConfigurableWebApplicationContext)) {
			ConfigurableWebApplicationContext cwac = (ConfigurableWebApplicationContext) wac;
			cwac.setServletContext(sc);
			cwac.setId("root");
			Resource res = cwac.getResource("classpath:framework/root.xml");
			try {
				DeploymentArchive archive = null;
				if (res.exists()) {
					cwac.setConfigLocation("classpath:framework/root.xml");
					archive = new DeploymentArchive("root.xml", res.getURL());
				} else {
					URL url = getClass().getClassLoader().getResource("root.xml");
					if (url != null) {
						cwac.setConfigLocation(url.toString());
						archive = new DeploymentArchive("root.xml", url);
					} else {
						throw new FrameworkException("can not find the context file which name is 'root.xml' in jar");
					}
				}
				archive.deploy(getWebRootPath());
			} catch (IOException e) {
				throw new FrameworkException("deploy root module failure", e);
			}
		} else {
			throw new FrameworkException("can not find the context file which name is 'root.xml' in classpath");
		}
		return wac;
	}

	public void contextInitialized(ServletContextEvent event) {
		logger.info("initialize context");
		super.contextInitialized(event);

		new SupportDeploymentArchives().scanArchives().deployArchives(getWebRootPath());
		new ModuleDeploymentArchives().scanArchives().deployArchives(getWebRootPath());
	}

	private String getWebRootPath() {
		String webroot = this.root.getServletContext().getRealPath("/");

		webroot = webroot.replaceAll("\\\\", "/");
		return webroot;
	}
}
