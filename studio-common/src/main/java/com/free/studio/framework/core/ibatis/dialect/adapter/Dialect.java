package com.free.studio.framework.core.ibatis.dialect.adapter;

/**
 * @Title: Dialect.java
 * @Package com.free.studio.framework.core.ibatis.dialect.adapter
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:40:07
 * @version V1.0
 */
public abstract class Dialect {
	public char openQuote() {
		return '"';
	}

	public char closeQuote() {
		return '"';
	}

	public boolean supportsRowValueConstructorSyntaxInInList() {
		return false;
	}
}
