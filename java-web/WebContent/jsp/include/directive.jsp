<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 정적인 방식
	String msg = "미리 포함된 directive.jsp의 msg..."; 

	//pageContext 영역에 등록
// 	pageContext.setAttribute("directive","pageContext : directive...");
	// 영역에 "directive"라는 이름으로 "directive..."값을 저장
	// int num = 10;와 같이
	// directive = "directive...";
	
	//request 영역에 등록
	request.setAttribute("directive","request : directive...");
%>
	<h2>정적 방식으로 삽입된 directive.jsp</h2>
	<!-- 
		파일을 삽입하는 형식이라면, 해당 주석이 보인다.
	 -->
