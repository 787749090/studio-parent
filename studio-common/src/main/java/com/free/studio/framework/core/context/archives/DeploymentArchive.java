package com.free.studio.framework.core.context.archives;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: DeploymentArchive.java
 * @Package com.free.studio.framework.core.context.archives
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:18:26
 * @version V1.0
 */
public class DeploymentArchive {
	private Logger logger = LoggerFactory.getLogger(getClass());
	public static final String JSP_RESOURCES_NAME = "jsp.resources.zip";
	public static final String RES_RESOURCES_NAME = "res.resources.zip";
	private boolean deploying = false;
	private String archiveName = null;
	private URL archiveURL = null;
	private String targetPath = null;

	public DeploymentArchive(String archiveName, URL archiveURL) {
		this.archiveName = archiveName;
		this.archiveURL = archiveURL;
	}

	public DeploymentArchive(String archiveName, URL archiveURL, String target) {
		this.archiveName = archiveName;
		this.archiveURL = archiveURL;
		this.targetPath = target;
	}

	public void deploy(String rootPath) throws IOException {
		if (!this.deploying) {
			this.deploying = true;

			String target = rootPath;
			if ((this.targetPath != null) && (this.targetPath.length() > 0)) {
				target = rootPath + this.targetPath;
			}
			unzipResources(this.archiveName, target, this.archiveURL, "jsp.resources.zip");
			unzipResources(this.archiveName, target, this.archiveURL, "res.resources.zip");
		}
	}

	public String getArchiveName() {
		return this.archiveName;
	}

	public URL getArchiveURL() {
		return this.archiveURL;
	}

	public String getTargetPath() {
		return this.targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	private void unzipResources(String archiveName, String rootPath, URL contextURL, String target) throws IOException {
		this.logger.info("start unzip resources:{},target:{}", archiveName, target);
		URL targetURL = new URL(contextURL, target);
		InputStream in = null;
		try {
			in = targetURL.openStream();
			if (in == null) {
				return;
			}
		} catch (FileNotFoundException e) {
			this.logger.warn("unzipResources ont found.ArchiveName:{},target:{},exception message:{}",
					new Object[] { archiveName, target, e.getMessage() });
			return;
		} catch (IOException e) {
			this.logger.warn("unzipResources error.ArchiveName:{},target:{},exception message:{}",
					new Object[] { archiveName, target, e.getMessage() });
			return;
		}
		ZipInputStream zis = new ZipInputStream(in);

		byte[] buff = new byte[1024];

		String webroot = rootPath.replaceAll("\\\\", "/");
		try {
			String unZipName = null;
			for (ZipEntry entry = zis.getNextEntry(); entry != null; entry = zis.getNextEntry()) {
				unZipName = webroot + entry.getName();
				this.logger.debug("unzip file:{}", unZipName);
				if (entry.isDirectory()) {
					new File(unZipName).mkdirs();
				} else {
					OutputStream os = new FileOutputStream(unZipName);
					int len = -1;
					while ((len = zis.read(buff)) != -1) {
						os.write(buff, 0, len);
					}
					os.close();
				}
			}
			try {
				zis.closeEntry();
			} catch (ZipException e) {
				this.logger.warn("ZipEntry Close Error==>>" + e.getMessage());
			} finally {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
			return;
		} finally {
			try {
				zis.closeEntry();
			} catch (ZipException e) {
				this.logger.warn("ZipEntry Close Error==>>" + e.getMessage());
			} finally {
				try {
					in.close();
				} catch (Exception e) {
				}
			}
		}
	}
}
