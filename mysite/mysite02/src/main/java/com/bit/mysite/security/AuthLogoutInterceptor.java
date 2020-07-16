package com.bit.mysite.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthLogoutInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session !=null) {
			session.removeAttribute("authUser");
			session.invalidate();
		}
		
		response.sendRedirect(request.getContextPath());
		
		// false 반환
		// -> Controller가 아니라 Interceptor 처리
		return false;
	}
	
	
}
