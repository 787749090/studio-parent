package com.free.studio.framework.core.ibatis;

import java.io.IOException;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;

/**
 * @Title: SqlSessionFactoryBean.java
 * @Package com.free.studio.framework.core.ibatis
 * @Description: TODO
 * @author yewp
 * @date 2017年5月9日 上午9:34:50
 * @version V1.0
 */
public class SqlSessionFactoryBean extends org.mybatis.spring.SqlSessionFactoryBean {
	private Interceptor interceptor = (Interceptor) new PaginationInterceptor();

	protected SqlSessionFactory buildSqlSessionFactory() throws IOException {
		SqlSessionFactory factory = super.buildSqlSessionFactory();

		factory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
		factory.getConfiguration().addInterceptor(this.interceptor);
		return factory;
	}
}
