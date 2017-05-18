package com.free.studio.framework.components.options.exception;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: MappingNotFoundException.java
 * @Package com.free.studio.framework.components.options.exception
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:49:41
 * @version V1.0
 */
public class MappingNotFoundException extends FrameworkException {
	public MappingNotFoundException(String optionType, Object value) {
		super("Mapping not found:type=" + optionType + "; value=" + value);
	}
}
