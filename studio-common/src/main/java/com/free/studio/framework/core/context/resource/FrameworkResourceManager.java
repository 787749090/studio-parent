package com.free.studio.framework.core.context.resource;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: FrameworkResourceManager.java
 * @Package com.free.studio.framework.core.context.resource
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:21:38
 * @version V1.0
 */
public class FrameworkResourceManager {
	public static final String URL_PREFIX = "framework:";
	private Map<String, Resource> resources = new HashMap();
	public static final FrameworkResourceManager INSTANCE = new FrameworkResourceManager();

	public static boolean isFrameworkResource(String url) {
		return url.startsWith("framework:");
	}

	public String registerResource(String context) {
		String id = "framework:" + UUID.randomUUID().toString();
		try {
			Resource res = new ByteArrayResource(context.getBytes("UTF-8"));
			this.resources.put(id, res);
		} catch (UnsupportedEncodingException e) {
			throw new FrameworkException(e.getMessage());
		}
		return id;
	}

	public void remove(String id) {
		this.resources.remove(id);
	}

	public Resource get(String id) {
		return (Resource) this.resources.get(id);
	}
}
