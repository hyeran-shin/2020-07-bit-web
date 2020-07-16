package com.bit.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.MemberDAO;
import com.bit.framework.ModelAndView;
import com.bit.framework.annotation.RequestMapping;
import com.bit.vo.MemberVO;

public class MemberController {
	
	@RequestMapping("/signUpForm.do")
	public ModelAndView signUpForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/member/signUpForm.jsp");
		return mav;
	}
	
	@RequestMapping("/signUp.do")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("pw");
		String email_id= request.getParameter("email_id");
		String email_domain ="";
		if( (email_domain = request.getParameter("email_domain1")) == "" ) {
			email_domain = request.getParameter("email_domain2");
		}
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String post = request.getParameter("post");
		String basic_addr = request.getParameter("basic_addr");
		String detail_addr = request.getParameter("detail_addr");
		
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setName(name);
		member.setPassword(password);
		member.setEmail_id(email_id);
		member.setEmail_domain(email_domain);
		member.setTel1(tel1);
		member.setTel2(tel2);
		member.setTel3(tel3);
		member.setPost(post);
		member.setBasic_addr(basic_addr);
		member.setDetail_addr(detail_addr);
		
		ServletContext sc = request.getServletContext();
		MemberDAO dao = (MemberDAO)sc.getAttribute("memberDAO");
		dao.memberInsert(member);
		
		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/member/signUp.jsp");
		return mav;
	}
	
	// 회원 탈퇴
	@RequestMapping("/memberDelete.do")
	public ModelAndView memberDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ServletContext sc = request.getServletContext();
		MemberDAO dao = (MemberDAO)sc.getAttribute("memberDAO");
		int result = dao.deleteMember(id);
		HttpSession session = request.getSession();
		session.invalidate();
		
		String msg = "";
		String url = "";
		if (result!=-1) {
			msg = "탈퇴 완료하였습니다";
			url = "/jblog-spring-prob/";
		} else {
			msg = "탈퇴 실패하였습니다.";
			url = "/jblog-spring-prob/boardWriteForm.do";
		}
	
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg", msg);
		mav.addAttribute("url", url);
		mav.setView("/WEB-INF/views/member/memberDelete.jsp");
		return mav;
	}

}
