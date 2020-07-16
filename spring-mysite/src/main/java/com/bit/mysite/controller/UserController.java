package com.bit.mysite.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mysite.service.UserService;
import com.bit.mysite.vo.UserVo;
import com.bit.security.Auth;
import com.bit.security.AuthUser;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	/*
	 * @ModelAttribute
	 * 		- joinform.jsp의 스프링 태그와 바인딩될 모델 객체 포함
	 * 		- UserVo 객체는 가지고 있는 제약사항(유효성)을 가지고,
	 * 		  spring form의 데이터와 연결
	 * 
	 * 		Servlet에서 UserVo 객체 생성 후 setAttribute() 대체하는 역할
	 * 		객체의 멤버와 이름이 일치한다면 자동 할당(바인딩, 매핑)이 이루어진다.
	 * 
	 * 		즉, UserVo를 Model로 등록을 했다.
	 * 		단, 이동할 페이지의 spring 요소 유지를 위한 연결일 뿐, 
	 * 		유효성을 검증하기 위한 @ModelAttribute 활용은 이 시점에서 아니다.
	 * 		기본적인 바인딩을 유지하기위해 씀. (joinform.jsp 에서의 <form:form~~> )
	 */
	@RequestMapping("/joinform")
	public String joinform(@ModelAttribute UserVo userVo) { // 유지하기 위한? setAttribute역할이 ModelAttrivute
		return "user/joinform"; // View 전달
	}

	// @Valid : Bean의 유효성 자동 검증
	//	-> 스프링 입력 폼으로부터 넘어오는 userVo의 데이터(값)가 유효한지 판단
	@RequestMapping("/join")
	public String join(@ModelAttribute @Valid UserVo userVo, BindingResult result) {
		
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError oe : list) {
				System.out.println("Object Error : " + oe);
			}
			return "user/joinform"; // 오류 있으면 현재 페이지 그대로
		}
		
		// 유저 서비스의 회원 가입을 수행해라 
		userService.join(userVo);
		
		return "redirect:/user/joinsuccess";
	}
	/**
	 * Spring MVC Redirect
	 * 		뷰 리졸버에 보낼 Context 경로의 접두어 활용
	 * 		"redirect:" + "/user/joinsuccess" 형식으로
	 * 		/user/joinsuccess 반환 값이 뷰 리졸버를 통해 가공되어
	 * 		이동을 수행하지만 포워드 방식이 아닌 리다이렉트로 이동
	 * 			-> 스프링에서 자동으로 변환이 된다.
	 * 		그 외의 페이지 이동 경로에 사용자 정의 접두어 활용하는 경우도 존재
	 * 			-> 접두어 가공 (프레임워크 개발 시 활용)
	 */		
	
	
	@RequestMapping("/joinsuccess")
	public String joinsuccess() { 
		return "user/joinsuccess";
	}
	

	@RequestMapping("/loginform")
	public String loginform(@ModelAttribute UserVo userVo) { // 유지하기 위한? setAttribute역할이 ModelAttrivute
		return "user/loginform";
	}
	
	
	/*
	 *  정보 수정 페이지 이동
	 *  	1. 로그인 인증(세션 확인)
	 *  		-> AuthInterceptor
	 * 		2. 인증 유저에 대한 파라미터 데이터 바인딩
	 * 			-> AuthUserHandlerMethodArgumentResolver
	 * 		3. DB에서 유저 정보 가져오기
	 * 			-> @Service(UserService), @Repository(UserDao)
	 * 		4. Model에 등록(userVo)
	 * 		5. View("user/modifyform") 반환
	 */
	
	@Auth
	@RequestMapping("/modifyform")
	public String modifyform(@AuthUser UserVo authUser, Model model) {
		// -> 핸들러 메소드 및 인증 파라미터에 대한 데이터 바인딩
		
		// 바인딩된 유저 객체에서 유저 번호를 추출 후 DB에서 유저의 모든 정보를 가져오겠다.
		UserVo vo = userService.getUser(authUser.getNo());
		model.addAttribute("userVo", vo); //Model
		
		return "user/modifyform"; //View
	}
	
	@RequestMapping("/modify")
//	public String modify(@AuthUser UserVo authUser, @ModelAttribute UserVo vo, BindingResult result) {
	public String modify(@AuthUser UserVo authUser ,@ModelAttribute @Valid UserVo vo, BindingResult result) {
		
		if(result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError oe : list) {
				System.out.println("modify Error : " + oe);
			}
			return "user/modifyform";
		}
		
		int r = userService.updateUser(vo);
		System.out.println("업데이트 결과 : " + r );
		authUser.setName(vo.getName());
		return "/user/modifysuccess";
	}
	
	@RequestMapping("/delete")
	public String delete(@AuthUser UserVo authUser, HttpSession session) {
//
//		if(session !=null) {
//	//		userService.deleteUser(authUser);
//			session.removeAttribute("authUser");
//			session.invalidate();
//		}
//		
//		response.sendRedirect(request.getContextPath());
		
		
		return "user/deleteform"; 
	}
	
}





