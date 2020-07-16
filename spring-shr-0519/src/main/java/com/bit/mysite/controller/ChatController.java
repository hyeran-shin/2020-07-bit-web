package com.bit.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChatController {

	
	@RequestMapping(value="/chat")
	public String index(Model model) {
		System.out.println("chat Controller");
		return "chat/index3";
	}
	
	@RequestMapping(value="/chat/login", method=RequestMethod.GET)
	public String login() {
		System.out.println("loginAPI!");
		return  "loginAPI/login2";
	}
	
	
	@RequestMapping(value="/chat/callback", method=RequestMethod.GET)
	public String callback() {
		System.out.println("loginAPI callback!");
		return  "loginAPI/callback";
	}
	
	
	
	@RequestMapping(value="/chat/loginok", method=RequestMethod.GET)
	public String loginok() {
		System.out.println("loginAPI OK!");
		return  "loginAPI/loginok";
	}
}
