package com.free.studio.framework.pureui.view;

/**
 * @Title: PagingInfo.java
 * @Package com.free.studio.framework.pureui.view
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:31:53
 * @version V1.0
 */
public class PagingInfo {

	private int currentPage;
	private int totalPage;
	private int currentCount;
	private int limitCount;
	private int totalCount;

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return this.totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentCount() {
		return this.currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getLimitCount() {
		return this.limitCount;
	}

	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
	}

	public int getTotalCount() {
		return this.totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
