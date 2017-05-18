package com.free.studio.framework.core.context.archives;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;

import com.free.studio.framework.core.context.ContextManager;

/**
 * @Title: DeploymentArchives.java
 * @Package com.free.studio.framework.core.context.archives
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:18:55
 * @version V1.0
 */
public class DeploymentArchives {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	public static final String UNDEFINED = "undefined";
	private List<DeploymentArchive> archives = new LinkedList();
	private boolean scanned = false;
	private boolean deployed = false;
	protected String archiveRegFile = null;
	protected String archiveRegNameKey = null;
	protected String archiveRegVerionKey = null;
	protected String archiveTargetKey = "";
	protected WebApplicationContext rootContext = null;

	protected DeploymentArchives() {
		initialize();
	}

	protected void initialize() {
		this.rootContext = ((WebApplicationContext) ContextManager.getRootContext());
		this.archiveRegFile = null;
		this.archiveRegNameKey = null;
		this.archiveRegVerionKey = null;
	}

	protected void deployArchive(DeploymentArchive dar, String rootPath) {
		try {
			dar.deploy(rootPath);
		} catch (IOException e) {
			throw new DeploymentException("deploymeng failure.archive:[" + dar.getArchiveName() + "]", e);
		}
	}

	protected DeploymentArchive buildDeploymentArchive(String archive, String version, URL archiveURL)
			throws IOException {
		DeploymentArchive dar = new DeploymentArchive(archive, archiveURL);
		return dar;
	}

	public void deployArchives(String rootPath) {
		if (this.deployed) {
			throw new DeploymentException("Repeat deployment");
		}
		DeploymentArchive dar = null;
		for (Iterator iterator = this.archives.iterator(); iterator.hasNext();) {
			dar = (DeploymentArchive) iterator.next();
			this.logger.info("begin deplpying archive:{}", dar.getArchiveName());
			deployArchive(dar, rootPath);
		}
		this.deployed = true;
	}

	public DeploymentArchives scanArchives() {
		if (this.scanned) {
			return this;
		}
		try {
			ClassLoader cl = getClass().getClassLoader();
			Enumeration enu = cl.getResources(this.archiveRegFile);
			while (enu.hasMoreElements()) {
				URL url = (URL) enu.nextElement();
				this.logger.info("{}' url is:{}", this.archiveRegFile, url.toString());

				Properties props = new Properties();
				props.load(url.openStream());
				String archive = props.getProperty(this.archiveRegNameKey, "undefined");
				String version = props.getProperty(this.archiveRegVerionKey, "undefined");
				String target = props.getProperty(this.archiveTargetKey, "");

				DeploymentArchive dar = buildDeploymentArchive(archive, version, url);

				dar.setTargetPath(target);
				this.archives.add(dar);
			}
			this.scanned = true;
		} catch (IOException e) {
			this.logger.error(e.getMessage(), e);
		}
		return this;
	}
}
