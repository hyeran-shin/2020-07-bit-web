package com.bit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.annotation.Auth;

@Controller
public class UserController {
	@RequestMapping("/login")
	public String login() {
		System.out.println("UserController login() Method Called...");
		return "/WEB-INF/views/loginSuccess.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		System.out.println("UserController logout() Method Called...");
		return "/WEB-INF/views/logoutSuccess.jsp"; 
	}
	
	@RequestMapping("/userlist")
	public String userlist() {
		System.out.println("UserController userlist() Method Called...");
		return "/WEB-INF/views/userList.jsp"; 
	}

	@Auth
	@RequestMapping("/modifyform")
	public String modifyform() {
		System.out.println("UserController modifyform() Method Called...");
		return "/WEB-INF/views/modifyForm.jsp"; 
	}
	
	
}
