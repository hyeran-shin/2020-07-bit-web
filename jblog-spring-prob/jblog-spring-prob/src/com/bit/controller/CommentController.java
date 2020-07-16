package com.bit.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.CommentDAO;
import com.bit.framework.ModelAndView;
import com.bit.framework.annotation.RequestMapping;
import com.bit.vo.CommentVO;

public class CommentController {
	
	@RequestMapping("/commentInsert.do")
	public ModelAndView commentInsert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String comment_content = request.getParameter("comment_content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String comment_id = request.getParameter("comment_id");
		int list_idx = Integer.parseInt(request.getParameter("list_idx"));
		
		CommentVO comment = new CommentVO();
		comment.setBoardNo(board_no);
		comment.setComment_content(comment_content);
		comment.setComment_id(comment_id);
		
		ServletContext sc = request.getServletContext();
		CommentDAO dao = (CommentDAO) sc.getAttribute("commentDAO");
		int result = dao.insertComment(comment);
		System.out.println("result : " + result);
		List<CommentVO> commentList = null;
		
		if(result != -1) {
			commentList = dao.selectAllComment(comment);
		}
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("list_idx", list_idx);
		mav.addAttribute("commentList", commentList);
		mav.addAttribute("type", "list");
		mav.addAttribute("no", board_no);
		mav.setView("/WEB-INF/views/board/detail.jsp");
		
		return mav;
	}
	

	@RequestMapping("/commentDelete.do")
	public ModelAndView commentDelete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_no = Integer.parseInt(request.getParameter("no"));
		int comment_no = Integer.parseInt(request.getParameter("c_no"));
		int list_idx = Integer.parseInt(request.getParameter("list_idx"));

		CommentVO comment = new CommentVO();
		comment.setCommentNo(comment_no);
		comment.setBoardNo(board_no);
		

		ServletContext sc = request.getServletContext();
		CommentDAO dao = (CommentDAO) sc.getAttribute("commentDAO");
		int result = dao.deleteComment(comment);
		
	
		
		String msg = "";
		String url = "";
		if (result != -1) {
			msg = "댓글 삭제 완료하였습니다.";
			url = "/jblog-spring-prob/boardDetail.do?no=" + board_no + "&type=list&list_idx="+list_idx;
		} else {
			msg = "댓글 삭제 실패하였습니다.";
			url = "/jblog-spring-prob/boardDetail.do?no="
					+ board_no + "&type=list&list_idx="+list_idx 
					+ "&comment_no="+comment_no;
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addAttribute("msg", msg);
		mav.addAttribute("url", url);
		mav.setView("/WEB-INF/views/board/comment.jsp");
		
		return mav;
	}
}





