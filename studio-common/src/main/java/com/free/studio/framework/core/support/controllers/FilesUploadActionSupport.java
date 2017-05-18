package com.free.studio.framework.core.support.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.multipart.MultiPartRequestWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: FilesUploadActionSupport.java
 * @Package com.free.studio.framework.core.support.controllers
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:47:56
 * @version V1.0
 */
public abstract class FilesUploadActionSupport extends ActionSupport {

	Logger logger = LoggerFactory.getLogger(FilesUploadActionSupport.class);

	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		Writer out = response.getWriter();
		try {
			if (!(request instanceof MultiPartRequestWrapper)) {
				String errorStr = "Not MultiPart Request.make sure the value of 'enctype' attribute  is 'multipart/form-data'.";
				this.logger.error(errorStr);
				throw new FrameworkException(errorStr);
			}
			MultiPartRequestWrapper multiWrapper = (MultiPartRequestWrapper) request;

			Enumeration fileParameterNames = multiWrapper.getFileParameterNames();
			while ((fileParameterNames != null) && (fileParameterNames.hasMoreElements())) {
				String inputName = (String) fileParameterNames.nextElement();

				String[] contentTypes = multiWrapper.getContentTypes(inputName);
				if (isNonEmpty(contentTypes)) {
					String[] fileNames = multiWrapper.getFileNames(inputName);
					if (isNonEmpty(fileNames)) {
						File[] files = multiWrapper.getFiles(inputName);
						if (files != null) {
							for (int index = 0; index < files.length; index++) {
								File file = files[index];
								InputStream is = new FileInputStream(file);
								try {
									handleUploadFile(is, file.length(), contentTypes[index], fileNames[index]);
								} finally {
									cleanUp(is, file);
								}
							}
						}
					} else {
						String errorStr = "Could not find a Filename for " + inputName
								+ ". Verify that a valid file was submitted";

						this.logger.error(errorStr);
						throw new FrameworkException(errorStr);
					}
				}
			}
			out.write("{status:'success'}");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.flush();
			out.close();
		}
		return super.execute();
	}

	protected abstract void handleUploadFile(InputStream paramInputStream, long paramLong, String paramString1,
			String paramString2);

	private static void cleanUp(InputStream is, File file) {
		try {
			is.close();
		} catch (Exception e) {
		}
		try {
			file.delete();
		} catch (Exception e) {
		}
	}

	private static boolean isNonEmpty(Object[] objArray) {
		boolean result = false;
		for (int index = 0; (index < objArray.length) && (!result); index++) {
			if (objArray[index] != null) {
				result = true;
			}
		}
		return result;
	}
}
