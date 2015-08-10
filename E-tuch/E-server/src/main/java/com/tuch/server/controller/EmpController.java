/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.controller
 * FILE    NAME: EmpController.java
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
import com.tuch.server.entity.Emp;
import com.tuch.server.service.IEmpService;

/**
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:55:11
 * @version <b>1.0.0</b>
 */

@RequestMapping("emp")
@Controller("empController")
public class EmpController {

	@Resource
	private IEmpService empService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String toListPage() {
		return "emp/empList";
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> list(int page, int rows, Emp emp) {

		Pagination<Emp> pagination = new Pagination<Emp>();// 分页信息
		pagination.setPageNo(page); // 页数
		pagination.setPageSize(rows); // 每页的条数

		Pagination<Emp> pager = empService.empList(pagination, emp);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pager.getTotalCount());
		map.put("rows", pager.getList());

		return map;
	}

}
