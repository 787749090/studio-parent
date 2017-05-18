package com.free.studio.framework.core.web.interceptors;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: InterceptorConfig.java
 * @Package com.free.studio.framework.core.web.interceptors
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:34:49
 * @version V1.0
 */
public class InterceptorConfig implements Comparable<InterceptorConfig> {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private Integer priority = Integer.valueOf(100);
	private String name = null;
	private GlobalWebInterceptor webInterceptor = null;
	private Pattern urlpattern;

	public InterceptorConfig(String name, String className, String regex, String priority) {
		this.name = name;
		try {
			this.webInterceptor = ((GlobalWebInterceptor) Class.forName(className).newInstance());
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
			throw new FrameworkException(e.getMessage());
		}
		this.urlpattern = Pattern.compile(regex);
		try {
			this.priority = Integer.valueOf(priority);
		} catch (Exception e) {
			this.priority = Integer.valueOf(100);
		}
	}

	public void cloneFrom(InterceptorConfig config) {
		this.name = config.name;
		this.priority = config.priority;
		this.urlpattern = config.urlpattern;
		this.webInterceptor = config.webInterceptor;
	}

	public Integer getPriority() {
		return this.priority;
	}

	public String getName() {
		return this.name;
	}

	public GlobalWebInterceptor getWebInterceptor() {
		return this.webInterceptor;
	}

	public void setWebInterceptor(GlobalWebInterceptor webInterceptor) {
		this.webInterceptor = webInterceptor;
	}

	public Pattern getUrlpattern() {
		return this.urlpattern;
	}

	public int compareTo(InterceptorConfig c) {
		return this.priority.compareTo(c.priority);
	}
}
