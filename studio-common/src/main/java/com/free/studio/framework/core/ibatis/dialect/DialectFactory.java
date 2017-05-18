package com.free.studio.framework.core.ibatis.dialect;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.session.Configuration;

import com.free.studio.framework.core.exception.FrameworkException;

/**
 * @Title: DialectFactory.java
 * @Package com.free.studio.framework.core.ibatis.dialect
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:36:04
 * @version V1.0
 */
public class DialectFactory {
	private static final String DIALECT_CONFIG = "dialect";
	private static final String DEFAULT_DIALECT = "mysql";
	private static final Map<String, Dialect> dialectMap = new HashMap();

	static {
		dialectMap.put("mysql", new MySqlDialect());
		dialectMap.put("oracle", new OracleDialect());
		dialectMap.put("mssql", new MsSqlDialect());
	}

	public static Dialect buildDialect(Configuration configuration) {
		Properties vars = configuration.getVariables();
		String dialectKey = vars == null ? null : vars.getProperty("dialect");
		if ((dialectKey == null) || (dialectKey.length() < 1)) {
			dialectKey = "mysql";
		}
		Dialect dialect = (Dialect) dialectMap.get(dialectKey);
		if (dialect == null) {
			throw new FrameworkException("not found the specified dialect.[" + dialect + "]");
		}
		return dialect;
	}
}
