/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.service.impl
 * FILE    NAME: IEmpServiceImpl.java
 */
package com.tuch.server.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tuch.common.util.Pagination;
import com.tuch.server.dao.IEmpDao;
import com.tuch.server.entity.Emp;
import com.tuch.server.service.IEmpService;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:48:35
 * @version <b>1.0.0</b>
 */
@Service
public class IEmpServiceImpl implements IEmpService {

	@Resource
	private IEmpDao empDao;

	/**
	 * 
	 * 
	 * @author jlyou
	 * @date 2015年8月7日 下午12:36:28
	 * @see com.tuch.server.service.IEmpService#empList(com.tuch.common.util.Pagination,
	 *      com.tuch.server.entity.Emp)
	 * @param pagination
	 * @param emp
	 * @return
	 */
	@Override
	public Pagination<Emp> empList(Pagination<Emp> pagination, Emp emp) {
		int start = pagination.getFirstResult();
		int pageSize = pagination.getPageSize();
		List<Emp> list = empDao.queryListForPage(emp, start, pageSize);
		int count = empDao.queryCount(emp).intValue();
		pagination.setTotalCount(count);
		pagination.setList(list);
		return pagination;
	}

}
