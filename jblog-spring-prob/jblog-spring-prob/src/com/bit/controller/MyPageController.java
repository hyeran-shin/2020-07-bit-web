package com.bit.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.dao.MemberDAO;
import com.bit.framework.ModelAndView;
import com.bit.framework.annotation.RequestMapping;
import com.bit.vo.MemberVO;

public class MyPageController {

	@RequestMapping("/myPage.do")
	public ModelAndView signUpForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		ServletContext sc = request.getServletContext();
		MemberDAO dao = (MemberDAO) sc.getAttribute("memberDAO");
		MemberVO member = dao.selectMember(id);
		HttpSession session = request.getSession();
		session.setAttribute("member", member);

		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/mypage/myPage.jsp");
		return mav;
	}

	@RequestMapping("/myPageModifyForm.do")
	public ModelAndView myPageModifyForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setView("/WEB-INF/views/mypage/myPageModifyForm.jsp");
		return mav;
	}

	@RequestMapping("/myPageModify.do")
	public ModelAndView myPageModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberVO member = new MemberVO();
		String id = request.getParameter("id");
		member.setId(id);
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("pw"));
		member.setEmail_id(request.getParameter("email_id"));

		String email_domain = "";
		if ((email_domain = request.getParameter("email_domain1")) == "") {
			email_domain = request.getParameter("email_domain2");
		}
		member.setEmail_domain(email_domain);

		member.setTel1(request.getParameter("tel1"));
		member.setTel2(request.getParameter("tel2"));
		member.setTel3(request.getParameter("tel3"));
		member.setPost(request.getParameter("post"));
		member.setBasic_addr(request.getParameter("basic_addr"));
		member.setDetail_addr(request.getParameter("detail_addr"));

		ServletContext sc = request.getServletContext();
		MemberDAO dao = (MemberDAO) sc.getAttribute("memberDAO");
		int result = dao.updateMember(member);
		String url="";
		String msg="";
				
		if (result != -1) {
			msg="수정 완료 하였습니다.";
			url="/jblog-spring-prob/myPage.do?id="+id;
		}else {
			msg="수정 실패 하였습니다.";
			url="/jblog-spring-prob/myPageModifyForm.do";
		}

		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg",msg);
		mav.addAttribute("url",url);
		mav.setView("/WEB-INF/views/mypage/myPageModify.jsp");
		return mav;
	}
}
