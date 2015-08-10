/*
 * PROJECT NAME: monitor-common
 * PACKAGE NAME: com.gjzq.monitor.module.common.dao
 * FILE    NAME: IGenericDao.java
 */
package com.tuch.common.dao;

import java.io.Serializable;
import java.util.List;

import com.tuch.common.entity.IEntity;

/**
 * @author Gary.Wang
 * @date 2014-8-13 下午2:13:47
 * @version <b>1.0.0</b>
 */
public interface IGenericDao<E extends IEntity<PK>, PK extends Serializable> {

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:14:44
	 * @param entity
	 * @return 受影响的行数
	 */
	int add(E entity);

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:14:55
	 * @param list
	 */
	void add(List<E> list);

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:14:58
	 * @param entity
	 * @return
	 */
	int update(E entity);

	/**
	 * 按主键查询单个对象
	 * 
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:15:02
	 * @param id
	 * @return
	 */
	E queryById(PK id);

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:15:05
	 * @param entity
	 * @return
	 */
	List<E> queryList(E entity);

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:15:17
	 * @param entity
	 * @param start
	 * @param pageSize
	 * @return
	 */
	List<E> queryListForPage(E entity, int start, int pageSize);

	/**
	 * @author Gary.Wang
	 * @date 2014-8-13 下午2:15:20
	 * @param entity
	 * @return
	 */
	Long queryCount(E entity);
}
