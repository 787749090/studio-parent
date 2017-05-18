package com.free.studio.framework.core.exception;

import org.springframework.core.NamedThreadLocal;

/**
 * @Title: ExceptionHolder.java
 * @Package com.free.studio.framework.core.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:28:31
 * @version V1.0
 */
public class ExceptionHolder {
	private static NamedThreadLocal<Throwable> cache = new NamedThreadLocal(ExceptionHolder.class.getName());

	public static void addException(Throwable error) {
		cache.set(error);
	}

	public static Throwable getException() {
		return (Throwable) cache.get();
	}

	public static void clearUp() {
		cache.remove();
	}
}
