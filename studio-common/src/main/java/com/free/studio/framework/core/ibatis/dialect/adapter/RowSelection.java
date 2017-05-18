package com.free.studio.framework.core.ibatis.dialect.adapter;

/**
 * @Title: RowSelection.java
 * @Package com.free.studio.framework.core.ibatis.dialect.adapter
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:41:04
 * @version V1.0
 */
public final class RowSelection {
	private Integer firstRow;
	private Integer maxRows;
	private Integer timeout;
	private Integer fetchSize;

	public void setFirstRow(Integer firstRow) {
		this.firstRow = firstRow;
	}

	public Integer getFirstRow() {
		return this.firstRow;
	}

	public void setMaxRows(Integer maxRows) {
		this.maxRows = maxRows;
	}

	public Integer getMaxRows() {
		return this.maxRows;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Integer getTimeout() {
		return this.timeout;
	}

	public Integer getFetchSize() {
		return this.fetchSize;
	}

	public void setFetchSize(Integer fetchSize) {
		this.fetchSize = fetchSize;
	}

	public boolean definesLimits() {
		return (this.maxRows != null) || ((this.firstRow != null) && (this.firstRow.intValue() <= 0));
	}
}
