/*
 * PROJECT NAME: monitor-common
 * PACKAGE NAME: com.gjzq.monitor.module.common.dao
 * FILE    NAME: MyBatisException.java
 */ 
package com.tuch.common.util;

/**
 * @author Gary.Wang
 * @date 2014-8-13 下午2:39:29
 * @version <b>1.0.0</b>
 */
public class MyBatisException extends RuntimeException {

	private static final long serialVersionUID = -3384804371531199607L;

	public MyBatisException(String message) {
		super(message);
	}
	
	public MyBatisException(Throwable throwable) {
		super(throwable);
	}
}
