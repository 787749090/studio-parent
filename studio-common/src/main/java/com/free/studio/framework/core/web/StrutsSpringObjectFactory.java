package com.free.studio.framework.core.web;

import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.utils.ContextUtils;
import com.opensymphony.xwork2.config.entities.ActionConfig;
import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;

/**
 * @Title: StrutsSpringObjectFactory.java
 * @Package com.free.studio.framework.core.web
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:26:20
 * @version V1.0
 */
public class StrutsSpringObjectFactory extends org.apache.struts2.spring.StrutsSpringObjectFactory {
	@Inject
	public StrutsSpringObjectFactory(
			@Inject(value = "struts.objectFactory.spring.autoWire", required = false) String autoWire,
			@Inject(value = "struts.objectFactory.spring.autoWire.alwaysRespect", required = false) String alwaysAutoWire,
			@Inject(value = "struts.objectFactory.spring.useClassCache", required = false) String useClassCacheStr,
			@Inject ServletContext servletContext, @Inject("struts.devMode") String devMode,
			@Inject Container container) {
		super(autoWire, alwaysAutoWire, useClassCacheStr, servletContext, devMode, container);
	}

	public Object buildAction(String actionName, String namespace, ActionConfig config,
			Map<String, Object> extraContext) throws Exception {
		return buildInternalActionBean(config.getClassName(), namespace, extraContext, true);
	}

	public Object buildInternalActionBean(String beanName, String namespace, Map<String, Object> extraContext,
			boolean injectInternal) throws Exception {
		ApplicationContext context = ContextUtils.getContext(namespace);
		Object obj = null;
		if (context.containsBean(beanName)) {
			obj = context.getBean(beanName);
		} else {
			Class beanClazz = getClassInstance(beanName);
			obj = buildBean(beanClazz, extraContext);
		}
		if (injectInternal) {
			injectInternalBeans(obj);
		}
		return obj;
	}
}
