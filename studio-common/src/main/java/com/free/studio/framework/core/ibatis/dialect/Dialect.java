package com.free.studio.framework.core.ibatis.dialect;

/**
 * @Title: Dialect.java
 * @Package com.free.studio.framework.core.ibatis.dialect
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:35:46
 * @version V1.0
 */
public abstract class Dialect {
	public abstract String getLimitString(String paramString, int paramInt1, int paramInt2);
}
