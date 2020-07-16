package com.bit.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit.mysite.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		// Handler Method -> modifyform(...)
		
		// 1단계 : handler 여부 판단
		if(handler instanceof HandlerMethod == false) {
			return true;
		}
		// 2단계 : @Auth 여부 판단
		Auth auth = ((HandlerMethod)handler).getMethodAnnotation(Auth.class);
		if(auth == null) {
			return true;
		}
		// auth.role() == "user" 로 할 수 있지만 null이냐 아니냐만 판단함.
		
		// 3단계 : 접근 제어 수행 (User Session) 
		HttpSession session = request.getSession();
		if(session == null) {
			response.sendRedirect(request.getContextPath()+"/user/loginform");
			return false; // 인터셉터의 흐름 중단
		}

		UserVo authUser = (UserVo) session.getAttribute("authUser");
		if( authUser == null ) {
			response.sendRedirect(request.getContextPath()+"/user/loginform");
			return false;
		}
		
		// 4단계 : 모든 인증 완료 (인증된 사용자)		
		return true;
	}
}

