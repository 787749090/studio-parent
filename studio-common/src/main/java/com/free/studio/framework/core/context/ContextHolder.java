package com.free.studio.framework.core.context;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.utils.ContextUtils;

/**
 * @Title: ContextHolder.java
 * @Package com.free.studio.framework.core.context
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:15:19
 * @version V1.0
 */
public class ContextHolder {

	private static Logger logger = LoggerFactory.getLogger(ContextHolder.class);
	private static final ThreadLocal<ApplicationContext> holder = new ThreadLocal();

	public static void register(ApplicationContext appcontext) {
		ApplicationContext context = get();
		if (context == null) {
			holder.set(appcontext);
		} else {
			logger.warn("Warn:ApplicationContext has already been registered.old context:{},new context id:{}",
					context.getId(), appcontext.getId());
		}
	}

	public static void register(HttpServletRequest request) {
		ApplicationContext context = get();
		if (context == null) {
			context = ContextUtils.getContext(request);
			holder.set(context);
		} else {
			logger.warn("Warn:ApplicationContext has already been registered.old context:{},new request uri:{}",
					context.getId(), request.getRequestURI());
		}
	}

	public static ApplicationContext get() {
		return (ApplicationContext) holder.get();
	}

	public static void release() {
		holder.set(null);
	}
}
