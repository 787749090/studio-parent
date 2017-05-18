package com.free.studio.framework.core.support.web.tag;

/**
 * @Title: PageButton.java
 * @Package com.free.studio.framework.core.support.web.tag
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:59:52
 * @version V1.0
 */
public class PageButton {

	public static String ICON_FIRST = "pagination-first";
	public static String ICON_PREV = "pagination-prev";
	public static String ICON_LOAD = "pagination-load";
	public static String ICON_NEXT = "pagination-next";
	public static String ICON_LAST = "pagination-last";
	public static String ICON_REFRESH = "pagination-refresh";
	public static String ISDISABLED = "isdisabled";
	public String isdisabled;
	public String icon;
	public String pageurl;

	public PageButton(String pageurl, String icon, String isdisabled) {
		this.isdisabled = isdisabled;
		this.icon = icon;
		this.pageurl = pageurl;
	}

	public String getIsdisabled() {
		return this.isdisabled;
	}

	public void setIsdisabled(String isdisabled) {
		this.isdisabled = isdisabled;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPageurl() {
		return this.pageurl;
	}

	public void setPageurl(String pageurl) {
		this.pageurl = pageurl;
	}
}
