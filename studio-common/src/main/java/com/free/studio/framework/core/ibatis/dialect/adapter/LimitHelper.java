package com.free.studio.framework.core.ibatis.dialect.adapter;

/**
 * @Title: LimitHelper.java
 * @Package com.free.studio.framework.core.ibatis.dialect.adapter
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:40:47
 * @version V1.0
 */
public class LimitHelper {
	public static boolean useLimit(LimitHandler limitHandler, RowSelection selection) {
		return (limitHandler.supportsLimit()) && (hasMaxRows(selection));
	}

	public static boolean hasFirstRow(RowSelection selection) {
		return getFirstRow(selection) > 0;
	}

	public static int getFirstRow(RowSelection selection) {
		return (selection == null) || (selection.getFirstRow() == null) ? 0 : selection.getFirstRow().intValue();
	}

	public static boolean hasMaxRows(RowSelection selection) {
		return (selection != null) && (selection.getMaxRows() != null) && (selection.getMaxRows().intValue() > 0);
	}
}
