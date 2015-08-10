/*
 * PROJECT NAME: monitor-common
 * PACKAGE NAME: com.gjzq.monitor.module.common.dao
 * FILE    NAME: AbstractGenericMyBatisDao.java
 */ 
package com.tuch.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.tuch.common.entity.IEntity;

/**
 * @author Gary.Wang
 * @date 2014-8-13 下午2:09:06
 * @version <b>1.0.0</b>
 */
public class AbstractGenericMyBatisDao<E extends IEntity<PK>, PK extends Serializable> extends SqlSessionDaoSupport implements IGenericDao<E, PK> {

	private Class<E> entityClass;
	
	@SuppressWarnings("unused")
	private Class<PK> pkClass;
	
	private final String namespace;

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:10:27
	 */
	@SuppressWarnings("unchecked")
	public AbstractGenericMyBatisDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
		this.pkClass = (Class<PK>) genericSuperclass.getActualTypeArguments()[1];
		this.namespace = entityClass.getName() + ".";
	}
	
	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:10:22
	 * @param entity
	 * @return
	 */
	public int add(E entity) {
		String statement = namespace + "add";
		return getSqlSession().insert(statement, entity);
	}

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:10:18
	 * @param entityList
	 */
	public void add(List<E> entityList) {
		String statement = namespace + "adds";
		getSqlSession().insert(statement, entityList);
	}

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午5:07:55
	 * @see com.gjzq.monitor.module.common.dao.IGenericDao#update(com.gjzq.common.entity.IEntity)
	 * @param entity
	 * @return
	 */
	public int update(E entity) {
		String statement = namespace + "update";
		return getSqlSession().update(statement, entity);
	}

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午5:07:51
	 * @see com.gjzq.monitor.module.common.dao.IGenericDao#queryById(java.io.Serializable)
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public E queryById(PK id) {
		String statement = namespace + "queryById";
		return (E)getSqlSession().selectOne(statement, id);
	}

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午5:07:47
	 * @see com.gjzq.monitor.module.common.dao.IGenericDao#queryList(com.gjzq.common.entity.IEntity)
	 * @param entity
	 * @return
	 */
	public List<E> queryList(E entity) {
		String statement = namespace + "queryList";
		return getSqlSession().selectList(statement, entity);
	}

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午5:07:35
	 * @see com.gjzq.monitor.module.common.dao.IGenericDao#queryListForPage(com.gjzq.common.entity.IEntity, int, int)
	 * @param entity
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<E> queryListForPage(E entity, int start, int limit) {
		String statement = namespace + "queryList";
		RowBounds rowBounds = new RowBounds(start, limit);
		return getSqlSession().selectList(statement, entity, rowBounds);
	}

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午5:08:09
	 * @see com.gjzq.monitor.module.common.dao.IGenericDao#queryCount(com.gjzq.common.entity.IEntity)
	 * @param entity
	 * @return
	 */
	public Long queryCount(E entity) {
		String statement = namespace + "queryCount";
		return (Long) getSqlSession().selectOne(statement, entity);
	}

	/**
	 * 获得entityClass
	 * @return Class<E>
	 */
	protected Class<E> getEntityClass() {
		return entityClass;
	}

	/**
	 * 获得namespace
	 * 
	 * @return String
	 */
	protected String getNamespace() {
		return namespace;
	}
}
