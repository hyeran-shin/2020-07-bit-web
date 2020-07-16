package com.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamModule
 */
@WebServlet("/Param03")
public class Param03 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Param03() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String name = "";
		String age = "";
		String addr = "";

		if ("POST".equals(request.getMethod()))
			request.setCharacterEncoding("utf-8");

		name = request.getParameter("name");
		age = request.getParameter("age");
		addr = request.getParameter("addr");

		PrintWriter out = response.getWriter();
		out.println("");
		out.println("name = " + name);
		out.println("age = " + age);
		out.print("addr = " + addr);
		out.close();
	}

}
