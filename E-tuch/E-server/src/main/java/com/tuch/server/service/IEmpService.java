/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.service
 * FILE    NAME: IEmpService.java
 */
package com.tuch.server.service;

import com.tuch.common.util.Pagination;
import com.tuch.server.entity.Emp;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:47:43
 * @version <b>1.0.0</b>
 */
public interface IEmpService {
	/**
	 * 
	 * emp 分页查询
	 * 
	 * @author jlyou
	 * @date 2015年8月7日 下午12:36:20
	 * @param pagination
	 * @param emp
	 * @return
	 */
	public Pagination<Emp> empList(Pagination<Emp> pagination, Emp emp);

}
