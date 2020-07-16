package com.bit.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.dto.JSONResult;
import com.bit.mysite.service.UserService;

@Controller("userAPIController") //표시 용도
@RequestMapping("/user/api")
public class UserController {
	//요청을 처리하는 컨트롤러
	
	/*
	 * @ResponseBody
	 * ~RequestResponseBodyMethodProcessor.handleReturnValue(...)
	 * 	-> 반환 값에 대한 처리 역할을 가진 메소드
	 *
	 */
	
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
