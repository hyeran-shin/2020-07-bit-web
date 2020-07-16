package com.bit.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "form/loginForm";
	}
	

	@RequestMapping("/login.do")
	public String login(UserVO user, Model model) {
		System.out.println("[전송된 유저 정보]");
		System.out.println("ID : " + user.getId());
		System.out.println("PW : " + user.getPw());
		System.out.println("name : " + user.getName());
		
		model.addAttribute("user",user);
		
		return "form/loginProcess";
	}
	
	/**
	 * Spring MVC Data Binding (데이터 바인딩)
	 * 	- @RequestParam, @ModelAttribute 생략
	 *  - 해당 요청이 들어오면 UserVO 객체의 default 생성자를 자동 호출
	 *  - 객체 생성 후 요청 파라미터와 객체의 멤버 변수를 바인딩한다.
	 *  - 요청 파라미터와 멤버 변수 이름의 매칭 수행
	 *  - Setter를 활용한 1:1 연결(Mapping)
	 */
	
	/**
	 *  Spring Annotation (스프링 어노테이션)
	 *  	@RequestParam
	 *  		- 요청 파라미터
	 *  		- 기본 required 속성이 true이기에, 모두 받아야 한다.
	 *  		- 필수 입력이 아니라면, requires 속성을 false로 지정.
	 *  		- Servlet에서의 다음 코드와 유사
	 *  			String id = requiest.getParameter("id");
	 *  
	 *  		[주의 사항]
	 *  		전달되는 인자 중 name이 없다면,
	 *  		@RequestParam("name") String name
	 *  			-> 400 Error - Bad Request
	 *  		@RequestParam(value="name", required=false) String name
	 *  			-> null
	 * 		@ModelAttribute
	 * 			- 클라이언트가 전달하는 파라미터를 1:1 프로퍼티 설정
	 * 			- 클라이언트가 보낸 여러 데이터 중 객체의 멤버와 일치한다면 자동 할당!
	 * 			- Servlet에서 UserVo 객체 생성 후 Setter와 setAttrivute()와 유사
	 * 
	 */
//	
//	@RequestMapping("/login.do")
//	public String login(@RequestParam("id") String id
//					  , @RequestParam("pw") String pw
//					  , @RequestParam("name") String name
//					  , @ModelAttribute("user") UserVO user) {
//		// @RequestParam Console logging...
//		System.out.println("ID : " + id);
//		System.out.println("PW : " + pw);
//		System.out.println("NAME : " + name);
//		
//		return "form/loginProcess";
//	}
	
	
	// 기존의 Servlet 방법 예시
	//	- HttpServletRequest 
	//	- 파라미터를 직접 받아와 등록
//	@RequestMapping("/login.do")
//	public String login(HttpServletRequest request) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//		String name = request.getParameter("name");
//		UserVO user = new UserVO();
//		user.setId(id);
//		user.setName(name);
//		user.setPw(pw);
//		request.setAttribute("user", user);
//		return "form/loginProcess";
//	}
	
	
	
	
}
