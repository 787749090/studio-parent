package com.free.studio.framework.pureui.utils;

import com.free.studio.framework.core.support.Pagination;
import com.free.studio.framework.pureui.view.JSONMessage;
import com.free.studio.framework.pureui.view.PageData;
import com.free.studio.framework.pureui.view.PagingInfo;

/**
 * @Title: MessageUtils.java
 * @Package com.free.studio.framework.pureui.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:28:47
 * @version V1.0
 */
public class MessageUtils {

	public static JSONMessage createPageMsg(Pagination page) {
		return createPageMsg(page, Boolean.valueOf(true), "");
	}

	public static JSONMessage createPageMsg(Pagination page, Boolean result, String msg) {
		JSONMessage messageView = new JSONMessage();

		PageData dataView = new PageData();
		dataView.setList(page.getData());

		PagingInfo pageView = new PagingInfo();
		pageView.setCurrentPage(page.getRowBounds().getPageNumber());
		pageView.setTotalPage(page.getPageTotal());
		pageView.setCurrentCount(page.getData().size());
		pageView.setLimitCount(page.getRowBounds().getLimit());
		pageView.setTotalCount(page.getTotal());
		dataView.setPage(pageView);

		messageView.setData(dataView);
		messageView.setMsg(msg);
		messageView.setResult(result);
		return messageView;
	}
}
