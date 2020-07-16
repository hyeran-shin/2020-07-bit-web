package com.bit.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hello");
		// 전달된 viewName인 "hello"는 view-resolver를 통해 실제 경로를 갖는다.
		// "/WEB-INF/vies/" + "hello" + ".jsp" 와 같이 가공
		
		mav.addObject("msg","Hello Spring MVC");
		return mav;
	}
}
