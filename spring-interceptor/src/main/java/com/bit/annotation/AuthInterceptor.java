package com.bit.annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception{
		System.out.println("AuthInterceptor.preHandle() Method Called...");
		/**
		 *  [로그인 시 인터셉터를 활용하는 목적]
		 *  유저 세션 확인이 필요한 기능들
		 *  	게시판 - insert, delete, update, ...
		 *  	회원정보수정 - modify, ...
		 *  	에서 각 기능 마다 세션 존재 여부를 확인할 필요가 없다.
		 * 		*각 기능(메소드)에 대한 세션 확인 중복 코드를 최소화!
		 * 
		 *  AuthInterceptor 역할
		 *  	Controller로 전달되는 모든 요청을 인터셉터로 받는다면,
		 *  	요청에 대한 각 예외 처리로 요청 URL에 따른 제어를 하겠다.
		 *  	인증접근제어라는 개념
		 *  
		 *  인증 접근 제어
		 *  	-> "/modifyForm" 요청 처리는 유저 세션이 존재할 경우에만
		 *  	-> 무조건 유저 세션을 확인할 필요가 있는 요청과 아닌 것을 분류
		 *  
		 *  정상 수행 : 인터셉터 수행 후 실제 실행할 목적지로 이어가라.
		 *  	-> return true;
		 */
		
		// 1. HandlerMethod 존재 여부
		System.out.println(handler); 
		// xml에 <mvc:annotation-driven> 하기 전에는 컨트롤러 객체가 튀어나옴. (UserController) 요청 받아지는 컨트롤러
		// xml 추가 후 public java.lang.String com.bit.controller.UserController.modifyform() 가 출력됨
		
		if( handler instanceof HandlerMethod == false) {
			return true;
		}
		/**
		 * 단순 페이지 이동 시 또는 @RequestMapping이 된 메소드가 없을 경우,
		 * 더 이상 인증 과정을 수행하지 말고, true로 종료 후 정상 수행으로 이어가라.
		 */
		
		// 2. @Auth 설정 여부
		Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
		// handler  -> HandlerMethod 형 변환 후, 형 변환 후의 객체의 메소드 호출!
		// (HandlerMethod) handler.getMethodAnnotation(Auth.class);
		// 	 -> handler의 메소드호출결과를 형 변환하는 형태
		// handelr : 매핑되는 정보를 가지고 있음(obj)
		
		if(auth == null) { // 접근 제어가 필요 없는 핸들러
			System.out.println("@Auth Not Exsist!!!");
			return true;
		}
		/**
		 *  제어할 메소드 (HandlerMethod)는 존재하지만, 인증 접근 제어가 필요 없는 경우
		 *  @Auth가 붙어 있지 않는 메소드, 더 이상 진행하지 말고 정상수행("/userList")
		 */

		// 3. 세션 확인을 통한 접근제어
		System.out.println("AuthUser Session Exist!!!");
		/**
		 *  [1단계] : 현재 세션 객체가 존재하는지 판단
		 *   @Auth 인증 관련 어노테이션이 붙어있다면, (null이 아니라면)
		 *   현재 세션 정보가 존재하는지 판단하여 세션 정보가 없다면,
		 *   다른 페이지로 보내겠다.
		 *   
		 *   	if(session == null){
		 *   		response.sendRedirect(
		 *   			request.getContextPath() + "[이동할 페이지 요청 URL]";
		 *   		);
		 *   	}
		 *  [2단계] : 현재 세션의 UserVO의 속성이 "authUser"인지 판단
		 *   세션은 존재하지만 인증된 사용자 (authUser)인지 판단하여,
		 *   아니라면 다른 페이지로 보내겠다.
		 *   	UserVO authUser = session.getAttribute("authUser");
		 *   	if(authUser == null){
		 *   		response.sendRedirect( 
		 *   			request.getContextPath() + "[이동할 페이지 요청 URL]";
		 *   		);
		 *   		return false;
		 *   	}
		 *   
		 */
		
		//4. 인증된 사용자
		return true;
		/**
		 *   인증 과정에서 중간에 반환되지 않은 경우
		 *   HandlerMethod가 존재하고, 
		 *   @Auth 설정이 되어있고,
		 *   session이 존재하며,
		 *   해당 session 정보가 authUser라면,
		 *   인증된 사용자이므로 정상 수행! 
		 */
		
	}
}














