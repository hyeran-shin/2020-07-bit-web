<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//세션 삭제
	session.invalidate();
%>
<h2>세션 삭제 완료</h2>
<a href="get.jsp"> 삭제 후 세션 확인</a>