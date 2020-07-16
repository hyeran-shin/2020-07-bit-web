<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//pageContext 영역에 등록
	pageContext.setAttribute("msg","page 영역의 msg");
	//request 영역에 등록
	request.setAttribute("msg","request 영역의 msg");
	//pageContext < request < session < Application 으로 msg 가 둘 다 같은 곳에 있으면 제일 가까운? 곳부터 탐색함
			
	// JSP 표현식을 활용하기 위해 영역의 데이터를 가져와라.
	// 	-> 영역의 데이터를 자바 변수에 담기 위해!

	String pageMsg =(String)pageContext.getAttribute("msg");
	String reqMsg = (String)request.getAttribute("msg");
	
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		EL의 스코프 탐색 순서(Scope를 지정하지 않았을 경우)
			pageContext -> request -> session -> application  
	 -->
	empty msg : ${empty msg} <br>
	<!-- 
		[EL의 내장 객체] 
			- 스코프 지정 방법
			pageScope, requestScope, sessionScope, applicationScope
	 -->
	
	page msg : ${msg} <br> <!-- 탐색에 의해 pageContext 영역의 msg -->
	request msg : ${requestScope.msg} <br> <!-- request영역의 msg -->
	
	<!-- JSP 표현식 -->
	pageContext msg : <%=pageMsg %> <br>
	request msg : <%=reqMsg %> <br>
	request msg : <%=request.getAttribute("msg") %> <br>
	
	<%--
		JSP 방법 : 해당 영역에 있는 Attribute를 간접적으로 가져와 활용(getter)
		EL  방법 : 해당 영역에 있는 Attribute를 직접 접근하여 활용
	 --%>
	
</body>
</html>





