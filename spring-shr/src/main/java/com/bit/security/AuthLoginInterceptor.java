package com.bit.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit.mysite.service.UserService;
import com.bit.mysite.vo.UserVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		UserService userService = ac.getBean(UserService.class);
	
		UserVo userVo = userService.login(email,password);
		if(userVo == null) { 
			response.sendRedirect(request.getContextPath() 
					+ "/user/loginform?result=fail");
			return false;
		}

		HttpSession session = request.getSession(true); 
		session.setAttribute("authUser", userVo);		
		response.sendRedirect(request.getContextPath()); 
		System.out.println("세션등록ㄹ드록록  : " + session.getAttribute("authUser"));
		return false;

	}
}





