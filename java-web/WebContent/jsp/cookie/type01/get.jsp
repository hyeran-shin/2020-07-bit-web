<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// 이미 존재하는 쿠키(JSESSION)가 있기에, 배열로 받겠다.
	Cookie[] cookies = request.getCookies();
	// 모든 쿠키 정보를 출력
	StringBuilder sb = new StringBuilder();
	if(cookies!=null){
		for(Cookie c : cookies){
			String cName = c.getName();
			String cValue = c.getValue();
			sb.append("쿠키 이름 : " + cName + ", ");
			sb.append("쿠키 값 : " + cValue + "<br>");
		}
	}else{
		sb.append("설정된 쿠키 정보가 없습니다.");
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>설정된 쿠키 정보</h2>
	<%=sb.toString() %>
	<a href="indexTest.jsp"> 쿠키 설정 화면 </a>
</body>
</html>