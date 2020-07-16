package com.bit.mysite.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private static final Log LOG = LogFactory.getLog(MainController.class);
	
	@RequestMapping(value= { "/main", "/" })
	public String index() {
		return "main/index";
	}
	
	
	//Logger Test
	@RequestMapping("/logger")
	public String logger() {
		LOG.debug("MainController.logger() Called...");
		
//		// 강제 실행 예외 발생!
//		if( 1 - 1 == 0) {
//			throw new RuntimeException("Logger Test RuntimeException...");
//		}
		return "TODO";
	}
}

