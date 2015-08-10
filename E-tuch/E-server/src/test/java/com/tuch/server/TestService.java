package com.tuch.server;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.tuch.common.util.Pagination;
import com.tuch.server.entity.ClientInfo;
import com.tuch.server.entity.Emp;
import com.tuch.server.service.IClientInfoService;
import com.tuch.server.service.IEmpService;

/**
 * Unit test for simple App.
 */
public class TestService extends AbstractSpringContextTests {
	@Resource
	private IClientInfoService clientInfoService;
	@Resource
	private IEmpService empService;

	public void testClientInfo() {

		Pagination<ClientInfo> pagination = new Pagination<ClientInfo>();
		pagination.setPageNo(1);
		pagination.setPageSize(20);
		Pagination<ClientInfo> clientInfoList = clientInfoService.clientInfoList(pagination);
		System.out.println(JSON.toJSONString(clientInfoList, true));

	}

	@Test
	public void test() {

		Pagination<Emp> pagination = new Pagination<Emp>();
		pagination.setPageNo(1);
		pagination.setPageSize(20);
		Pagination<Emp> clientInfoList = empService.empList(pagination, null);
		System.out.println(JSON.toJSONString(clientInfoList, true));
	}

}
