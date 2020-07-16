package com.bit.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dto.JSONResult;
import com.bit.mysite.service.UserService;

@Controller("userAPIController") 
@RequestMapping("/user/api")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("/checkemail")
	public JSONResult checkemail(
			@RequestParam(value="email", required=true, defaultValue="")String email) {
		boolean result = userService.emailExists(email);
		return JSONResult.success(result ? "exist" : "not exist");
	}
}
