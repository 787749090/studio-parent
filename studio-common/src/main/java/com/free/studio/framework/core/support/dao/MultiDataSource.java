package com.free.studio.framework.core.support.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @Title: MultiDataSource.java
 * @Package com.free.studio.framework.core.support.dao
 * @Description: TODO
 * @author yewp
 * @date 2017年5月8日 下午5:51:18
 * @version V1.0
 */
public abstract class MultiDataSource implements DataSource {

	private DataSource masterDataSource;
	private DataSource[] backupDataSources;

	private boolean hasBackup() {
		return (this.backupDataSources != null) || (this.backupDataSources.length > 0);
	}

	private Connection getBackupConnection() {
		Connection conn = null;

		return conn;
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			conn = this.masterDataSource.getConnection();
		} catch (SQLException e) {
			if (!hasBackup()) {
			}
		}
		return this.masterDataSource.getConnection();
	}

	public Connection getConnection(String username, String password) throws SQLException {
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		throw new UnsupportedOperationException("getLogWriter");
	}

	public int getLoginTimeout() throws SQLException {
		return 0;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new UnsupportedOperationException("setLogWriter");
	}

	public void setLoginTimeout(int seconds) throws SQLException {
		throw new UnsupportedOperationException("setLoginTimeout");
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		if (!DataSource.class.equals(iface)) {
			throw new SQLException("DataSource of type [" + getClass().getName()
					+ "] can only be unwrapped as [javax.sql.DataSource], not as [" + iface.getName());
		}
		return (T) this;
	}
}
