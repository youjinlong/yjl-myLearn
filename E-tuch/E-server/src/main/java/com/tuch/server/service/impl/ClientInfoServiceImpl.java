/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.service.impl
 * FILE    NAME: ClientInfoServiceImpl.java
 */
package com.tuch.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tuch.common.util.Pagination;
import com.tuch.server.dao.IClientInfoDao;
import com.tuch.server.entity.ClientInfo;
import com.tuch.server.service.IClientInfoService;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年7月23日 下午2:01:48
 * @version <b>1.0.0</b>
 */
@Service
public class ClientInfoServiceImpl implements IClientInfoService {

	@Resource
	private IClientInfoDao clientDao;

	/**
	 * 
	 * @author jlyou
	 * @date 2015年7月23日 下午2:02:00
	 * @see com.tuch.server.service.IClientInfoService#clientInfoList()
	 * @return
	 */
	@Override
	public Pagination<ClientInfo> clientInfoList(Pagination<ClientInfo> pagination) {

		int start = pagination.getFirstResult();
		int pageSize = pagination.getPageSize();
		List<ClientInfo> list = clientDao.queryListForPage(null, start, pageSize);
		int count = clientDao.queryCount(null).intValue();
		pagination.setTotalCount(count);
		pagination.setList(list);
		return pagination;
	}

}
