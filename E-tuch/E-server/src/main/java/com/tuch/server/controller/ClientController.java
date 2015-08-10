/*
 * PROJECT NAME: E-common
 * PACKAGE NAME: com.tuch.common
 * FILE    NAME: TestController.java
 */
package com.tuch.server.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuch.common.util.Pagination;
import com.tuch.server.entity.ClientInfo;
import com.tuch.server.service.IClientInfoService;

@Controller
@RequestMapping("client")
public class ClientController {

	@Resource
	private IClientInfoService clientInfoService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String toListPage() {
		return "client/clientList";
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(int page, int rows) {

		Pagination<ClientInfo> pagination = new Pagination<ClientInfo>();// 分页信息
		pagination.setPageNo(page); // 页数
		pagination.setPageSize(rows); // 每页的条数

		Pagination<ClientInfo> pager = clientInfoService.clientInfoList(pagination);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pager.getTotalCount());
		map.put("rows", pager.getList());

		return map;
	}

}
