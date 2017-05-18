package com.free.studio.framework.core.validation;

/**
 * @Title: Constraint.java
 * @Package com.free.studio.framework.core.validation
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:23:16
 * @version V1.0
 */
public abstract interface Constraint {
	public abstract void validate(String paramString1, String paramString2);

	public abstract String generateJavaScript();
}
