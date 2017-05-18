package com.free.studio.framework.core.context.archives;

import org.springframework.web.context.WebApplicationContext;

import com.free.studio.framework.core.context.ContextManager;

/**
 * @Title: SupportDeploymentArchives.java
 * @Package com.free.studio.framework.core.context.archives
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:20:07
 * @version V1.0
 */
public class SupportDeploymentArchives extends DeploymentArchives {
	protected void initialize() {
		this.rootContext = ((WebApplicationContext) ContextManager.getRootContext());
		this.archiveRegFile = "deployment.properties";
		this.archiveRegNameKey = "archive-name";
		this.archiveRegVerionKey = "archive-version";

		this.archiveTargetKey = "archive-target";
	}
}
