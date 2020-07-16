package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.annotation.Auth;

@Controller
public class UserController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@Auth
	@RequestMapping("/login")
	public String login() {
		System.out.println("UserController login() Method Called...");
		return "loginSuccess";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		System.out.println("UserController logout() Method Called...");
		return "logoutSuccess";
	}
	
	
}
