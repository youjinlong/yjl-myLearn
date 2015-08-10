/*
 * PROJECT NAME: E-server
 * PACKAGE NAME: com.tuch.server.controller
 * FILE    NAME: MainController.java
 */
package com.tuch.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * TODO（描述类的职责）
 * 
 * @author jlyou
 * @date 2015年8月6日 下午3:56:37
 * @version <b>1.0.0</b>
 */
@Controller
public class MainController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String toMainPage() {
		return "main";
	}
}
