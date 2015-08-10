/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.dao.impl
 * FILE    NAME: ClientInfoDaoImpl.java
 */
package com.tuch.server.dao.impl;

import org.springframework.stereotype.Repository;

import com.tuch.common.dao.AbstractGenericMyBatisDao;
import com.tuch.server.dao.IClientInfoDao;
import com.tuch.server.entity.ClientInfo;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年7月23日 下午1:28:27
 * @version <b>1.0.0</b>
 */
@Repository
public class ClientInfoDaoImpl extends AbstractGenericMyBatisDao<ClientInfo, String> implements IClientInfoDao {

}
