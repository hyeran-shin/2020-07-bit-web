package com.bit.hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
	@RequestMapping("/hello2")
	public ModelAndView hello2() {
		String data="Spring Boot";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data",data);
		mav.setViewName("hello");
				
		return mav;
	}
}
