package com.bit.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	// 1. HandlerMethod 존재 여부
	// 2. @Auth 설정 여부
	// 3. 세션 확인을 통한 접근제어
	// 4. 인증된 사용자
	
	private static final Log LOG = LogFactory.getLog(AuthInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler ) throws Exception{
		System.out.println("AuthInterceptor.preHandler() Method Called...");

		LOG.debug("#AuthInterceptor.preHandle() - debug log");
		LOG.info("#AuthInterceptor.preHandle() - info log");
		LOG.warn("#AuthInterceptor.preHandle() - warn log");
		LOG.error("#AuthInterceptor.preHandle() - error log");
		
		
		if( handler instanceof HandlerMethod == false) {
			System.out.println("Handler 없음");
			return true;
		}
		
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
		
		if(auth == null) {
			System.out.println("@Auth 존재하지 않음");
			return true;
		}else {
			
			System.out.println("AuthUser Session 있음");
		}
		System.out.println("뭐야뭐ㅑ");
		
		return true;
	}
	
}







