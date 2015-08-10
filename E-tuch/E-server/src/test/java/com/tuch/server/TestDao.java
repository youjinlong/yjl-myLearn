/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server
 * FILE    NAME: TestDao.java
 */
package com.tuch.server;

import javax.annotation.Resource;

import org.junit.Test;

import com.tuch.server.dao.IEmpDao;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:44:09
 * @version <b>1.0.0</b>
 */
public class TestDao extends AbstractSpringContextTests {

	@Resource
	private IEmpDao empDao;

	@Test
	public void testEmp() {
		System.out.println(empDao.queryCount(null));
	}

}
