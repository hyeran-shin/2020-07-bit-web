<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//pageContext 영역에 등록
	// 	pageContext.setAttribute("action","pageContext : action..."); //null 이면 안나옴?

			
	//request 영역에 등록
	request.setAttribute("action", "request : action...");
%>
<h2>동적으로 수행하는 action.jsp</h2>
<!-- p 태그 (본문 태그) -->
<p>include 시 넘어온 파라미터 확인</p>
<!-- include 시 param으로 전달 받을 때
 param 내장객체를 이용해서 param 값 받음. -->
<p>전달 파라미터 : ${param.id}</p>


