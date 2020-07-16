<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = "";
	String age = ""; 
	String addr = "";
	
	if("POST".equals(request.getMethod()))
		request.setCharacterEncoding("utf-8");
	
	name = request.getParameter("name");
	age = request.getParameter("age");
	addr = request.getParameter("addr");
	
%>name = <%= name %>
age = <%= age %>
addr = <%= addr %>