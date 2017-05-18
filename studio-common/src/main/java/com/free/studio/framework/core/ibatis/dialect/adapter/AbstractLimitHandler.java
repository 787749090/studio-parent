package com.free.studio.framework.core.ibatis.dialect.adapter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: AbstractLimitHandler.java
 * @Package com.free.studio.framework.core.ibatis.dialect.adapter
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午6:05:55
 * @version V1.0
 */
public abstract class AbstractLimitHandler implements LimitHandler {
	protected final String sql;
	protected final RowSelection selection;

	public AbstractLimitHandler(String sql, RowSelection selection) {
		this.sql = sql;
		this.selection = selection;
	}

	public boolean supportsLimit() {
		return false;
	}

	public boolean supportsLimitOffset() {
		return supportsLimit();
	}

	public boolean supportsVariableLimit() {
		return supportsLimit();
	}

	public boolean bindLimitParametersInReverseOrder() {
		return false;
	}

	public boolean bindLimitParametersFirst() {
		return false;
	}

	public boolean useMaxForLimit() {
		return false;
	}

	public boolean forceLimitUsage() {
		return false;
	}

	public int convertToFirstRowValue(int zeroBasedFirstResult) {
		return zeroBasedFirstResult;
	}

	public String getProcessedSql() {
		throw new UnsupportedOperationException("Paged queries not supported by " + getClass().getName());
	}

	public int bindLimitParametersAtStartOfQuery(PreparedStatement statement, int index) throws SQLException {
		return bindLimitParametersFirst() ? bindLimitParameters(statement, index) : 0;
	}

	public int bindLimitParametersAtEndOfQuery(PreparedStatement statement, int index) throws SQLException {
		return !bindLimitParametersFirst() ? bindLimitParameters(statement, index) : 0;
	}

	public void setMaxRows(PreparedStatement statement) throws SQLException {
	}

	protected int bindLimitParameters(PreparedStatement statement, int index) throws SQLException {
		if ((!supportsVariableLimit()) || (!LimitHelper.hasMaxRows(this.selection))) {
			return 0;
		}
		int firstRow = convertToFirstRowValue(LimitHelper.getFirstRow(this.selection));
		int lastRow = getMaxOrLimit();
		boolean hasFirstRow = (supportsLimitOffset()) && ((firstRow > 0) || (forceLimitUsage()));
		boolean reverse = bindLimitParametersInReverseOrder();
		if (hasFirstRow) {
			statement.setInt(index + (reverse ? 1 : 0), firstRow);
		}
		statement.setInt(index + ((reverse) || (!hasFirstRow) ? 0 : 1), lastRow);
		return hasFirstRow ? 2 : 1;
	}

	protected int getMaxOrLimit() {
		int firstRow = convertToFirstRowValue(LimitHelper.getFirstRow(this.selection));
		int lastRow = this.selection.getMaxRows().intValue();
		return useMaxForLimit() ? lastRow + firstRow : lastRow;
	}
}
