package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// HandlerInterceptor Interface
public class MyInterceptor01 implements HandlerInterceptor {
	// preHandle() : 유저 요청 후, 컨트롤러 수행 전 수행된다
	// -> 컨트롤러로 요청이 들어가기 전에 호출되어 수행된다.
	// -> 중간에 요청을 가로채 원하는 동작이 가능하다.

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		System.out.println("MyInterceptor01.preHandle() Called...");
		return true;
		// true : 정상적으로 컨트롤러를 수행해라 (*요청을 이어가라)
		// false : 컨트롤러를 수행하지 마라(*요청을 이어가지 마라)
	}

	// postHandle() : 컨트롤러 수행 후, 화면 응답 전 수행된다.
	// 처리가 필요한 놈들의 인자를 자동으로 받아준다. 
	//  -> postHandle : ModelAndView, afterCompletion : Exception
	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object obj, ModelAndView mav)
			throws Exception {
		System.out.println("MyInterceptor01.postHandle() Called...");
	}

	// afterCompletion() : 컨트롤러 수행 후, 화면 응답 후에 수행( 전부완료 됐을 시 수행되는 것)
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object obj, Exception ex)
			throws Exception {
		System.out.println("MyInterceptor01.afterCompletion() Called...");
	}
}
