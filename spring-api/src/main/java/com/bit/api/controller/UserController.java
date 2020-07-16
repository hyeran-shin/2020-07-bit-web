package com.bit.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.domain.User;
import com.bit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/list")
	@ResponseBody
	public Object checkUserInfo() {
		List<User> list = userService.getAllUsers();
		
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success"); //API 요청 성공 여부
		map.put("data", list); // 요청 데이터
		
		return map;
	}
}
