package com.free.studio.framework.core.ibatis.dialect;

/**
 * @Title: MySqlDialect.java
 * @Package com.free.studio.framework.core.ibatis.dialect
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:37:00
 * @version V1.0
 */
public class MySqlDialect extends Dialect {
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect.append("select * from (  ");

		pagingSelect.append(sql);

		pagingSelect.append(" ) _t LIMIT ").append(offset).append(" ,").append(limit);

		return pagingSelect.toString();
	}
}
