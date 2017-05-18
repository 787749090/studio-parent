package com.free.studio.framework.core.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.free.studio.framework.core.i18n.LocaleHolder;

/**
 * @Title: AbstractSupport.java
 * @Package com.free.studio.framework.core.support
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:05:19
 * @version V1.0
 */
public class AbstractSupport implements ApplicationContextAware {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected ApplicationContext appContext;

	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.appContext = context;
	}

	protected String getText(String message, Object[] args) {
		return this.appContext.getMessage(message, args, LocaleHolder.getLocale());
	}

	protected String getText(String message) {
		return this.appContext.getMessage(message, null, LocaleHolder.getLocale());
	}
}
