package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HandlerInterceptorAdapter Abstract Class
//	- 인터페이스는 모두 재정의해야한다.
//	- 하나만 재정의 하도록 추상 클래스 상송
//	- *HandlerInterceptor Interface의 구현체인 Adapter 활용!
public class MyInterceptor02 extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception{
		System.out.println("MyInterceptor02.preHandle() Method Called...");
		return true;
	}
}
