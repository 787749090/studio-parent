package com.free.studio.framework.core.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: DBUtils.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:18:17
 * @version V1.0
 */
public class DBUtils {
	public static List<String> getColumnsByTable(Connection conn, String tableName) throws SQLException {
		return getColumnsByTable(conn, tableName, null, null);
	}

	public static List<String> getColumnsByTable(Connection conn, String tableName, String schema) throws SQLException {
		return getColumnsByTable(conn, tableName, schema, null);
	}

	public static List<String> getColumnsByTable(Connection conn, String tableName, String schema, String catalog)
			throws SQLException {
		List<String> list = new ArrayList();
		ResultSet rs = conn.getMetaData().getColumns(catalog, schema, tableName, "%");
		while (rs.next()) {
			list.add(rs.getString("COLUMN_NAME"));
		}
		return list;
	}

	public static List<Map<String, Object>> queryNamedSqlToList(Connection connection, String namedSQL,
			Map<String, Object> params) throws SQLException {
		ResultSet rs = queryNamedSql(connection, namedSQL, params);
		try {
			List<Map<String, Object>> result = resultSetToList(rs);
			return result;
		} finally {
			close(rs, true);
		}
	}

	public static Object queryNamedSqlToSingle(Connection connection, String namedSQL, Map<String, Object> params)
			throws SQLException {
		ResultSet rs = queryNamedSql(connection, namedSQL, params);
		try {
			if (rs.next()) {
				return rs.getObject(1);
			}
			throw new SQLException("There are at least one record in ResultSet");
		} finally {
			close(rs, true);
		}
	}

	public static ResultSet queryNamedSql(Connection connection, String namedSQL, Map<String, Object> params)
			throws SQLException {
		List<String> paramNames = new ArrayList();
		String sql = SqlParamUtil.buildExecutableSQL(namedSQL, paramNames);
		PreparedStatement ps = connection.prepareStatement(sql);
		initNamedParameters(ps, paramNames, params);
		return ps.executeQuery();
	}

	public static int executeNamedSql(Connection connection, String namedSQL, Map<String, Object> params)
			throws SQLException {
		List<String> paramNames = new ArrayList();
		String sql = SqlParamUtil.buildExecutableSQL(namedSQL, paramNames);
		PreparedStatement ps = connection.prepareStatement(sql);
		try {
			initNamedParameters(ps, paramNames, params);
			return ps.executeUpdate();
		} finally {
			close(ps);
		}
	}

	public static void initNamedParameters(PreparedStatement ps, List<String> paramNames, Map<String, Object> params)
			throws SQLException {
		for (int index = 0; index < paramNames.size(); index++) {
			String paramName = (String) paramNames.get(index);
			Object value = params.get(paramName);
			if ((value == null) && (!params.containsKey(paramName))) {
				throw new SQLException("Missing Parameter.Parameter Name:" + paramName);
			}
			SqlParamUtil.setParameter(ps, index + 1, value);
		}
	}

	public static List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
		List<Map<String, Object>> result = new ArrayList();

		ResultSetMetaData meta = rs.getMetaData();
		while (rs.next()) {
			Map<String, Object> rowData = new LinkedHashMap();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				rowData.put(meta.getColumnName(i), rs.getObject(i));
			}
			result.add(rowData);
		}
		return result;
	}

	public static void close(Connection cn) {
		if (null != cn) {
			try {
				cn.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(Statement stmt) {
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
	}

	public static void close(ResultSet rs, boolean autoCloseStatement) {
		if (!autoCloseStatement) {
			close(rs);
		} else {
			Statement stat = null;
			try {
				stat = rs.getStatement();
			} catch (SQLException e) {
			}
			close(rs, stat);
		}
	}

	public static void close(ResultSet rs, Statement stmt) {
		close(rs);
		close(stmt);
	}
}
