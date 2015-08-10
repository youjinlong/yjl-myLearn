/*
 * PROJECT NAME: monitor-common
 * PACKAGE NAME: com.gjzq.monitor.module.common.dao
 * FILE    NAME: PagingIntercept.java
 */
package com.tuch.common.util;

import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * mybatis分页插件。
 * 
 * @author jlyou
 * @date 2014-11-28
 * @version <b>1.0.0</b>
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class PagingIntercept implements Interceptor {

	private MySqlPagingDialect pagingDialect = new MySqlPagingDialect();

	public Object intercept(Invocation invocation) throws Throwable {
		// query(MappedStatement ms, Object parameter, RowBounds rowBounds,
		// ResultHandler resultHandler) throws SQLException;
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameter = args[1];
		RowBounds rowBounds = (RowBounds) args[2];
		int offset = rowBounds.getOffset();
		int limit = rowBounds.getLimit();
		if (pagingDialect.supportsPaging() && (offset != RowBounds.NO_ROW_OFFSET || limit != RowBounds.NO_ROW_LIMIT)) {
			BoundSql boundSql = ms.getBoundSql(parameter);
			String sql = boundSql.getSql().trim();
			sql = pagingDialect.getPagingSql(sql, offset, limit);
			offset = RowBounds.NO_ROW_OFFSET;
			limit = RowBounds.NO_ROW_LIMIT;
			args[2] = new RowBounds(offset, limit);
			BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
			copyMetaParameters(boundSql, newBoundSql);
			MappedStatement newMs = copyFromMappedStatement(ms, new BoundSqlSqlSource(newBoundSql));
			args[0] = newMs;
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		String className = (String) properties.get("dialect");
		if (StringUtils.isEmpty(className)) {
			return;
		}
		Class<?> dialectClass = null;
		try {
			dialectClass = ClassUtils.forName(className);
		} catch (Exception e) {
			throw new MyBatisException(e);
		}
		pagingDialect = (MySqlPagingDialect) BeanUtils.instantiate(dialectClass);
	}

	private void copyMetaParameters(BoundSql lhs, BoundSql rhs) {
		for (ParameterMapping map : lhs.getParameterMappings()) {
			String key = map.getProperty();
			Object value = lhs.getAdditionalParameter(key);
			if (null != value) {
				rhs.setAdditionalParameter(key, value);
			}
		}
	}

	// see: MapperBuilderAssistant
	private MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
		Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		// builder.keyProperty(ms.getKeyProperty());
		builder.keyProperty(delimitedArraytoString(ms.getKeyProperties()));
		// setStatementTimeout()
		builder.timeout(ms.getTimeout());
		// setStatementResultMap()
		builder.parameterMap(ms.getParameterMap());
		// setStatementResultMap()
		builder.resultMaps(ms.getResultMaps());
		builder.resultSetType(ms.getResultSetType());
		// setStatementCache()
		builder.cache(ms.getCache());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());
		return builder.build();
	}

	private String delimitedArraytoString(String[] array) {
		if (array == null) {
			return null;
		}
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			stringBuffer.append(array);
			if (i != (array.length - 1)) {
				stringBuffer.append(",");
			}
		}
		return stringBuffer.toString();
	}

	public static class BoundSqlSqlSource implements SqlSource {

		private BoundSql boundSql;

		public BoundSqlSqlSource(BoundSql boundSql) {
			this.boundSql = boundSql;
		}

		public BoundSql getBoundSql(Object parameterObject) {
			return boundSql;
		}
	}

	public static class MySqlPagingDialect {

		private static final String LIMIT = " rownum ";

		public boolean supportsPaging() {
			return Boolean.TRUE;
		}

		public String getPagingSql(String sql, int offset, int limit) {

			sql = sql.trim();
			String forUpdateClause = null;
			boolean isForUpdate = false;
			final int forUpdateIndex = sql.toLowerCase().lastIndexOf("for update");
			if (forUpdateIndex > -1) {
				// save 'for update ...' and then remove it
				forUpdateClause = sql.substring(forUpdateIndex);
				sql = sql.substring(0, forUpdateIndex - 1);
				isForUpdate = true;
			}

			StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
			if (offset > 0) {
				pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
			} else {
				pagingSelect.append("select * from ( ");
			}
			pagingSelect.append(sql);
			if (offset > 0) {
				pagingSelect.append(" ) row_ where rownum <= " + (limit + offset) + ") where rownum_ > " + offset);
			} else {
				pagingSelect.append(" ) where rownum <= " + limit);
			}

			if (isForUpdate) {
				pagingSelect.append(" ");
				pagingSelect.append(forUpdateClause);
			}
			return pagingSelect.toString();

		}
	}
}
