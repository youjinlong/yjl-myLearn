/*
 * PROJECT NAME: E-common
 * PACKAGE NAME: com.tuch.common
 * FILE    NAME: TestController.java
 */
package com.tuch.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class TestController {

	@RequestMapping("test")
	public String test() {
		System.out.println("-------------------------------------");
		return "test";
	}

}
