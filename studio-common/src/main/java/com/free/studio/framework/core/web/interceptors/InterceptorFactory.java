package com.free.studio.framework.core.web.interceptors;

import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.exception.FrameworkException;
import com.free.studio.framework.core.utils.EmptyUtils;

/**
 * @Title: InterceptorFactory.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:35:07
 * @version V1.0
 */
public class InterceptorFactory {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private LinkedList<InterceptorConfig> interceptors = new LinkedList();
	private String configFile = "interceptors.properties";
	private ClassLoader classLoader = null;

	public void loadInterceptors() {
		ClassLoader cl = this.classLoader == null ? getClass().getClassLoader() : this.classLoader;
		Enumeration<URL> enu = null;
		try {
			enu = cl.getResources(this.configFile);
			Map<String, InterceptorConfig> snapshoot = new HashMap();
			while (enu.hasMoreElements()) {
				URL url = (URL) enu.nextElement();
				this.logger.info("loading interceptor config file:{}", url.toString());
				Properties props = new Properties();
				props.load(url.openStream());

				String interceptorsString = props.getProperty("interceptors");
				if (!EmptyUtils.isEmpty(interceptorsString)) {
					String[] interceptorStrs = interceptorsString.split(",");
					for (int i = 0; i < interceptorStrs.length; i++) {
						String name = interceptorStrs[i];
						String urlpattern = props.getProperty(name + ".urlpattern");
						String className = props.getProperty(name + ".class");
						String priority = props.getProperty(name + ".priority");
						InterceptorConfig config = new InterceptorConfig(name, className, urlpattern, priority);
						InterceptorConfig same = (InterceptorConfig) snapshoot.get(config.getName());
						if (same == null) {
							snapshoot.put(config.getName(), config);
							this.interceptors.add(config);
						} else if (config.getPriority().intValue() > same.getPriority().intValue()) {
							same.cloneFrom(config);
						}
					}
				}
			}
			Collections.sort(this.interceptors);

			Collections.reverse(this.interceptors);
		} catch (Exception e) {
			throw new FrameworkException("load interceptor config file error", e);
		}
	}

	public List<GlobalWebInterceptor> matchInterceptors(HttpServletRequest request) {
		List<GlobalWebInterceptor> list = new LinkedList();
		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length());
		if (EmptyUtils.isNotEmpty(uri)) {
			for (InterceptorConfig config : this.interceptors) {
				if (config.getUrlpattern().matcher(uri).find()) {
					list.add(config.getWebInterceptor());
				}
			}
		}
		return list;
	}
}
