/*
 * PROJECT NAME: monitor-common
 * PACKAGE NAME: com.gjzq.monitor.module.common.entity
 * FILE    NAME: IEntity.java
 */ 
package com.tuch.common.entity;

/**
 * @author Gary.Wang
 * @date 2014-8-13 下午2:11:19
 * @version <b>1.0.0</b>
 */
public interface IEntity<PK> {

	void setId(PK pk);
	
	PK getId();
}
