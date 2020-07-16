package com.bit.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit.mysite.service.UserService;
import com.bit.mysite.vo.UserVo;

// 인터셉터임
public class AuthLoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		// Web Application Context 가져오기
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// Context(Container)에 존재하는 UserService Bean 가져오기
		UserService userService = ac.getBean(UserService.class);
		
		// DB에서 해당 UserVo 받아오기
		//	-> @Service에서 호출한 @Repository의 결과다.
		UserVo userVo = userService.login(email,password);
		
		// 로그인 정보가 일치하지 않은 경우 (이메일, 패스워드)
		if(userVo == null) { 
			response.sendRedirect(request.getContextPath() 
					+ "/user/loginform?result=fail");
			// 로그인 화면으로 되돌리되, 실패 인자를 전달! -> "fail"
			// 로그인 화면에서 JSTL 조건을 통해 로그인 실패 요소를 유저에게 보여주겠다.
			return false;
		}
		// 인증 처리(세션 등록)
		HttpSession session = request.getSession(true); // 세션 정보를 가져와
		session.setAttribute("authUser", userVo);		// 인증 유저 세션 등록 후,
		response.sendRedirect(request.getContextPath()); // 메인화면으로 이동
		System.out.println("세션등록ㄹ드록록  : " + session.getAttribute("authUser"));
		return false;
		// Controller 없이 Interceptor 영역에서
		// 미들웨어처럼 로그인 처리를 수행!
		// -> 조건에 따른 페이지 이동 sendRedirect()
		// -> 페이지 이동 후 Interceptor 종료, false 반환
		// return false는 없음, 호출한 곳이 없기 때문에?
	}
}





