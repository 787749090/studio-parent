package com.free.studio.framework.core.exception;

import org.springframework.context.ApplicationContext;

import com.free.studio.framework.core.i18n.LocaleHolder;
import com.free.studio.framework.core.utils.ContextUtils;

/**
 * @Title: BusinessException.java
 * @Package com.free.studio.framework.core.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:28:11
 * @version V1.0
 */
public class BusinessException extends SpecialHandlingException {
	private static final long serialVersionUID = -7763568815766243495L;
	public static final String MSG_KEY_PREFIX = "error.";
	protected String errorCode = null;
	protected String message = null;

	public BusinessException(String errorCode) {
		this.errorCode = errorCode;
		ApplicationContext ctx = getApplicationContext();
		this.message = ctx.getMessage(this.errorCode, null, LocaleHolder.getLocale());
	}

	public BusinessException(String errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
		ApplicationContext ctx = getApplicationContext();
		this.message = ctx.getMessage(this.errorCode, null, LocaleHolder.getLocale());
	}

	protected ApplicationContext getApplicationContext() {
		return ContextUtils.getContext(parseModuleName());
	}

	protected String parseModuleName() {
		try {
			int begin = "error.".length();
			int end = this.errorCode.indexOf(".", begin);
			return this.errorCode.substring(begin, end);
		} catch (IndexOutOfBoundsException e) {
			throw new FrameworkException(e.getMessage(), e);
		}
	}

	public String getMessage() {
		return this.message;
	}
}
