package com.free.studio.framework.pureui.view;

import java.util.List;

import com.free.studio.framework.core.support.model.BaseView;

/**
 * @Title: PageData.java
 * @Package com.free.studio.framework.pureui.view
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:30:56
 * @version V1.0
 */
public class PageData extends BaseView {

	private PagingInfo page;
	private List<Object> list;

	public PagingInfo getPage() {
		return this.page;
	}

	public void setPage(PagingInfo page) {
		this.page = page;
	}

	public List<Object> getList() {
		return this.list;
	}

	public void setList(List<Object> list) {
		this.list = list;
	}
}
