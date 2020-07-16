<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String id = (String) session.getAttribute("id");
	String pw = (String) session.getAttribute("pw");
%>

<br>
설정된 아이디 :<%=id%><br>
설정된 비밀번호 :<%=pw%><br>

<a href="remove.jsp">세션 삭제</a>