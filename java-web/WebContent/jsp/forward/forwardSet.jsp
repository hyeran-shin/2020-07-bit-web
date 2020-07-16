<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//html에서 넘어온 파라미터 값을 getParameter로 뽑음 
	//서버에서 뽑아서 유지시키기 위해 자바웹서버인 영역 request에 setAttrubute를 해줌
	//indexTest.jsp에서 넘어온 HTML(GET) 요청 파라미터를 request 영역에 등록
// 	request.setAttribute("id",request.getParameter("id"));
	request.setAttribute("tid",request.getParameter("id"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
		JSP 태그(액션태그)
			파라미터 전달(Parameter)
			 - 대상에게 메소드의 인자처럼 단순히 데이터 전달
			 - HTML 문서상에 존재하는 데이터 -> *클라이언트
			      서버단의 데이터가 아닌 클라이언트단의 데이터 활용
			영역을 공유(Attribute) request
			 - 내 자신 영역에 존재하는 데이터를 같이 사용
			 - 서버단에서 공유되는 영역 -> *서버
			 
			indexTest.jsp -> forwardSet.jsp
			(파라미터 전달, 영역을 공유하는 것은 아니다.)
			
			forwardSet.jsp -> user.jsp
			(파라미터 전달, 영역을 공유하는 것은 아니다.)
			
			<jsp:param /> : forward, include에서 활용, 파라미터 전달
			
			[전달된 파라미터를 받는 방법]
			${param.id} -> EL의 받는 방법
			requset.getParameter("id") -> JSP의 받는 방법
	 --%>
	<!-- 파라미터를 전달하지 않은 경우 -->
	<jsp:forward page="admin.jsp"/>

	<!--
		forwardSet.jsp?id=yes
		파라미터(전달 인자)	-> id
		값(전달된 데이터)	-> yes
	  -->
	<!-- 파라미터를 전달하는 경우 -->
<%-- 	<jsp:forward page="user.jsp"> --%>
<%-- 		<jsp:param name ="uid" value="${param.id}+10"/> --%>
<%-- 	</jsp:forward> --%>
	<!-- 
		indexTest.jsp 에서 get 방식으로 넘어온 파라미터를
		uid 라는 이름으로 user.jsp로 전달
	 -->
	 <a href="param.jsp"> 이동!</a>
</body>
</html>