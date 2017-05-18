package com.free.studio.framework.core.utils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title: SqlParamUtil.java
 * @Package com.free.studio.framework.core.utils
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 下午2:21:32
 * @version V1.0
 */
public class SqlParamUtil {
	private static Pattern sqlParametersPattern = Pattern.compile("\\:(\\w|[^U4E00-U9FA5\\s,.'\\\"\\]\\)\\(\\[])+", 32);

	public static String buildExecutableSQL(String sql, List<String> paramNames) {
		Matcher matcher = sqlParametersPattern.matcher(sql);
		while (matcher.find()) {
			MatchResult result = matcher.toMatchResult();
			String name = result.group().substring(1);
			paramNames.add(name);
		}
		return matcher.replaceAll("?");
	}

	public static List<String> parseSqlParams(String sql) {
		Matcher matcher = sqlParametersPattern.matcher(sql);
		List<String> vars = new ArrayList();
		while (matcher.find()) {
			MatchResult result = matcher.toMatchResult();
			String name = result.group().substring(1);
			vars.add(name);
		}
		return vars;
	}

	public static void setParameter(PreparedStatement statement, int index, Object object) throws SQLException {
		if (object == null) {
			statement.setNull(index, 0);
		} else if ((object instanceof Date)) {
			statement.setDate(index, (Date) object);
		} else if ((object instanceof Timestamp)) {
			statement.setTimestamp(index, (Timestamp) object);
		} else {
			statement.setObject(index, object);
		}
	}
}
