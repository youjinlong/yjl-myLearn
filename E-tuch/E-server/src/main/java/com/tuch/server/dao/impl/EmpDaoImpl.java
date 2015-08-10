/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.dao.impl
 * FILE    NAME: EmpDaoImpl.java
 */
package com.tuch.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuch.common.dao.AbstractGenericMyBatisDao;
import com.tuch.server.dao.IEmpDao;
import com.tuch.server.entity.Emp;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:35:50
 * @version <b>1.0.0</b>
 */
@Repository
public class EmpDaoImpl extends AbstractGenericMyBatisDao<Emp, String> implements IEmpDao {

}
