package com.bit.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.LoginDAO;
import com.bit.framework.ModelAndView;
import com.bit.framework.annotation.RequestMapping;
import com.bit.vo.LoginVO;

public class LoginController {
	@RequestMapping("/loginForm.do")
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/login/loginForm.jsp");
		return mav;
	}

	@RequestMapping("/login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		LoginVO login = new LoginVO();
		login.setId(id);
		login.setPassword(pw);
	
		ServletContext sc = request.getServletContext();
		LoginDAO dao = (LoginDAO) sc.getAttribute("loginDAO");
		LoginVO user = dao.login(login);
		
		String msg = "";
		String url = "";
		if (user != null) {
			HttpSession session = request.getSession();

			session.setAttribute("user", user);

			switch (user.getType()) {
			case "S":
				msg = user.getName() + " 관리자님 환영합니다.";
			case "U":
				msg = user.getName() + " 회원님 환영합니다.";
			}

			url = request.getContextPath();
		} else {
			msg = "ID 혹은 Password가 잘못 되었습니다.";
			url = "/jblog-spring-prob/loginForm.do";
		}

		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg", msg);
		mav.addAttribute("url", url);
		mav.setView("/WEB-INF/views/login/login.jsp");
		return mav;
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();
		
		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/login/logout.jsp");
		return mav;
	}

}
