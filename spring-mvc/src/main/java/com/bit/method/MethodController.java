package com.bit.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/signUp.do")
public class MethodController {
	// signUp.do 요청을 모두 받아 GET인지 POST인지 판단하여,
	// 각각의 메소드 수행
	
	@RequestMapping(method=RequestMethod.GET)
	public String callGet() {
		return "method/signUpForm";
		// Model 없이, View만 반환
		// ModelAndView를 활용하지 않고, View 경로만 반환
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String callPost() {
		return "method/signUpProcess";
	}
}
