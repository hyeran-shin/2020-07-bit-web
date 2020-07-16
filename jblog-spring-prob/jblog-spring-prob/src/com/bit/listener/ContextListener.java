package com.bit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.bit.dao.BoardDAO;
import com.bit.dao.CommentDAO;
import com.bit.dao.LoginDAO;
import com.bit.dao.MemberDAO;

public class ContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext sc = sce.getServletContext();
		MemberDAO memberDAO = new MemberDAO();
		sc.setAttribute("memberDAO", memberDAO);
		LoginDAO loginDAO = new LoginDAO();
		sc.setAttribute("loginDAO", loginDAO);
		BoardDAO boardDAO = new BoardDAO();
		sc.setAttribute("boardDAO", boardDAO);
		CommentDAO commentDAO = new CommentDAO();
		sc.setAttribute("commentDAO", commentDAO);
		
		
	} 

	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}


}
