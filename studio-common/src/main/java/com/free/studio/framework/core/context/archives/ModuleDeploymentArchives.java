package com.free.studio.framework.core.context.archives;

import java.io.IOException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.free.studio.framework.core.Environment;
import com.free.studio.framework.core.context.ContextManager;
import com.free.studio.framework.core.context.MergeableApplicationContext;
import com.free.studio.framework.core.web.servlet.ServletHandler;

/**
 * @Title: ModuleDeploymentArchives.java
 * @Package com.free.studio.framework.core.context.archives
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:19:44
 * @version V1.0
 */
public class ModuleDeploymentArchives extends DeploymentArchives {
	private static final String ENVIRONMENT_FILE_NAME = "classpath:environment.xml";
	protected String archiveContextFormat = null;

	public ModuleDeploymentArchives() {
		initialize();
	}

	protected void initialize() {
		this.rootContext = ((WebApplicationContext) ContextManager.getRootContext());
		this.archiveRegFile = "module-plugin.properties";
		this.archiveRegNameKey = "module-name";
		this.archiveRegVerionKey = "module-version";
		this.archiveContextFormat = "modules-{0}.xml";
	}

	protected DeploymentArchive buildDeploymentArchive(String archive, String version, URL archiveURL)
			throws IOException {
		String resName = new MessageFormat(this.archiveContextFormat).format(new String[] { archive });
		URL location = getClass().getClassLoader().getResource(resName);
		addModuleContext(archive, version, location);
		DeploymentArchive dar = new DeploymentArchive(archive, archiveURL);
		return dar;
	}

	protected void addModuleContext(String moduleName, String version, URL location) throws IOException {
		XmlWebApplicationContext wac = new MergeableApplicationContext(moduleName, version, this.rootContext, location);
		wac.refresh();
		ContextManager.addModule(moduleName, wac);

		this.logger.info("====>>add Module:{}", moduleName);
		Environment env = (Environment) wac.getBean(Environment.class);
		this.logger.warn("Environment Name:{},Version:{}", env.getModuleName(), env.getVersion());

		Map<String, ServletHandler> handlers = wac.getBeansOfType(ServletHandler.class);
		for (Iterator iter = handlers.values().iterator(); iter.hasNext();) {
			ServletHandler handler = (ServletHandler) iter.next();
			handler.init(wac.getServletContext());
			this.logger.debug("init ServletHandler:" + handler.getClass());
		}
		this.logger.info("{} ServletHandlers have been initialized in {} module.", Integer.valueOf(handlers.size()),
				moduleName);
	}
}
