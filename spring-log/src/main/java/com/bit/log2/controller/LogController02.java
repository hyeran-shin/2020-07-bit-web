package com.bit.log2.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController02 {
	/**
	 *  Logger 생성(File)
	 */
	private static final Log LOG = LogFactory.getLog(LogController02.class);
	
	@RequestMapping("/ex02")
	@ResponseBody
	public String ex02() {
		LOG.debug("#ex02 - debug log");
		LOG.info("#ex02 - info log");		
		LOG.warn("#ex02 - warn log");		
		LOG.error("#ex02 - error log");	
		
		return "Logback Logging Ex02 Response..."; 
	}
}
