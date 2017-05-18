package com.free.studio.framework.core.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Title: IOUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:19:31
 * @version V1.0
 */
public class IOUtils {
	public static byte[] toByteArray(InputStream is) throws IOException {
		return org.apache.commons.io.IOUtils.toByteArray(is);
	}

	public static void toFile(InputStream is, File file) throws IOException {
		FileOutputStream out = new FileOutputStream(file);
		try {
			byte[] cont = new byte[512];
			int len = 0;
			while ((len = is.read(cont)) > 0) {
				out.write(cont, 0, len);
			}
			return;
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
			try {
				is.close();
			} catch (IOException e) {
			}
		}
	}
}
