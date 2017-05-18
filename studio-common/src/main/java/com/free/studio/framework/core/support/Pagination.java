package com.free.studio.framework.core.support;

import java.io.Serializable;
import java.util.List;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: Pagination.java
 * @Package com.free.studio.framework.core.support
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午6:05:58
 * @version V1.0
 */
public class Pagination implements Serializable {

	private int total = 0;
	private List<Object> data;
	private RowBounds rowBounds;

	public Pagination(RowBounds rowBounds, int total) {
		this.rowBounds = new RowBounds(rowBounds.getPageNumber(), rowBounds.getLimit());
		this.total = total;
	}

	public Pagination(RowBounds rowBounds, int total, List<Object> data) {
		this.rowBounds = new RowBounds(rowBounds.getPageNumber(), rowBounds.getLimit());
		this.total = total;
		setData(data);
	}

	public RowBounds getRowBounds() {
		return new RowBounds(this.rowBounds.getPageNumber(), this.rowBounds.getLimit());
	}

	public List<Object> getData() {
		return this.data;
	}

	public void setData(List<Object> data) {
		this.data = data;
		if ((data != null) && (data.size() > this.total)) {
			throw new FrameworkException("data.size>total.please check total.");
		}
	}

	public int getTotal() {
		return this.total;
	}

	public int getPageTotal() {
		int size = this.rowBounds.getLimit();
		return (int) Math.ceil(this.total * 1.0D / size);
	}
}
