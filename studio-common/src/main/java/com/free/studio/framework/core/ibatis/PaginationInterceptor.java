package com.free.studio.framework.core.ibatis;

import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.free.studio.framework.core.ibatis.dialect.Dialect;
import com.free.studio.framework.core.ibatis.dialect.DialectFactory;

/**
 * @Title: PaginationInterceptor.java
 * @Package com.free.studio.framework.core.ibatis
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:33:39
 * @version V1.0
 */
@Intercepts({ @org.apache.ibatis.plugin.Signature(type = StatementHandler.class, method = "prepare", args = {
		java.sql.Connection.class }) })
public class PaginationInterceptor implements Interceptor {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, null, null);

		RowBounds rowBounds = (RowBounds) metaObject.getValue("delegate.rowBounds");
		if ((rowBounds != null) && (rowBounds.getLimit() > 0) && (rowBounds.getLimit() < 2147483647)) {
			String originalSql = (String) metaObject.getValue("delegate.boundSql.sql");

			Configuration configuration = (Configuration) metaObject.getValue("delegate.configuration");
			Dialect dialect = DialectFactory.buildDialect(configuration);

			int offset = rowBounds.getOffset();
			int limit = rowBounds.getLimit();
			try {
				metaObject.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, offset, limit));
				metaObject.setValue("delegate.rowBounds.offset", Integer.valueOf(0));
				metaObject.setValue("delegate.rowBounds.limit", Integer.valueOf(2147483647));

				BoundSql boundSql = statementHandler.getBoundSql();
				this.logger.debug("paging sql: {}", boundSql.getSql());
				Object localObject1 = invocation.proceed();
				return localObject1;
			} finally {
			}
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties arg0) {
	}
}
