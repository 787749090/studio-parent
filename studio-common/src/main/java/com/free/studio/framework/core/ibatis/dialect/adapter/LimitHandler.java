package com.free.studio.framework.core.ibatis.dialect.adapter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Title: LimitHandler.java
 * @Package com.free.studio.framework.core.ibatis.dialect.adapter
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午11:40:30
 * @version V1.0
 */

public abstract interface LimitHandler {
	public abstract boolean supportsLimit();

	public abstract boolean supportsLimitOffset();

	public abstract String getProcessedSql();

	public abstract int bindLimitParametersAtStartOfQuery(PreparedStatement paramPreparedStatement, int paramInt)
			throws SQLException;

	public abstract int bindLimitParametersAtEndOfQuery(PreparedStatement paramPreparedStatement, int paramInt)
			throws SQLException;

	public abstract void setMaxRows(PreparedStatement paramPreparedStatement) throws SQLException;
}
