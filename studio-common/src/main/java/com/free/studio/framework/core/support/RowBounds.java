package com.free.studio.framework.core.support;

import java.io.Serializable;

/**
 * @Title: RowBounds.java
 * @Package com.free.studio.framework.core.support
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:06:25
 * @version V1.0
 */
public class RowBounds extends org.apache.ibatis.session.RowBounds implements Serializable {

	private int offset = 0;
	private int limit = 2147483647;
	private int pageNumber = 0;

	public RowBounds() {
	}

	public RowBounds(int pageNumber, int pageSize) {
		this.limit = pageSize;
		this.pageNumber = pageNumber;
		this.offset = ((pageNumber - 1) * pageSize);
	}

	public int getLimit() {
		return this.limit;
	}

	public int getOffset() {
		return this.offset;
	}

	public int getPageNumber() {
		return this.pageNumber;
	}
}
