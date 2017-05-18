package com.free.studio.framework.core.ibatis;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;

/**
 * @Title: ResultSetHandlerInterceptor.java
 * @Package com.free.studio.framework.core.ibatis
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:34:20
 * @version V1.0
 */
@Intercepts({
		@org.apache.ibatis.plugin.Signature(type = org.apache.ibatis.executor.resultset.ResultSetHandler.class, method = "handleResultSets", args = {
				java.sql.Statement.class }) })
public class ResultSetHandlerInterceptor implements Interceptor {
	public Object intercept(Invocation invocation) throws Throwable {
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}
