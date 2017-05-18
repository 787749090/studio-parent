package com.free.studio.framework.pureui.view;

import com.free.studio.framework.core.support.RowBounds;

/**
 * @Title: PagingCondition.java
 * @Package com.free.studio.framework.pureui.view
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:31:25
 * @version V1.0
 */
public class PagingCondition extends Condition {

	protected int pageIndex;
	protected int pageSize;

	public int getPageIndex() {
		return this.pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public RowBounds buildBounds() {
		return new RowBounds(this.pageIndex, this.pageSize);
	}
}
