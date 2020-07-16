package com.bit.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("Request Logging...");
		return "/WEB-INF/views/hello.jsp";
	}
}
