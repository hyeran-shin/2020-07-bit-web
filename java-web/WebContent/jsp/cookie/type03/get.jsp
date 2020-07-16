<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder"%>
<!DOCTYPE html>
<%
	// 이미 존재하는 쿠키(JSESSION)가 있기에, 배열로 받겠다.
	Cookie[] cookies = request.getCookies();
	
	/*
		Percnet-Encoding(퍼센트 인코딩, URL Encoding)
			- URL에 문자를 표현하기 위한 문자 인코딩 방법
			- 16진수 단위로 표현
	*/

	// 모든 쿠키 정보를 출력
	StringBuilder sb = new StringBuilder();
	if (cookies != null) {
		for (Cookie c : cookies) {
			String cName = c.getName();
			cName = URLDecoder.decode(cName, "utf-8");
			String cValue = c.getValue();
			cValue = URLDecoder.decode(cValue, "utf-8");
			sb.append("쿠키 이름 : " + cName + ", ");
			sb.append("쿠키 값 : " + cValue + "<br>");
		}
	} else {
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
	<%=sb.toString()%>
	<a href="indexTest.jsp"> 쿠키 설정 화면 </a>
</body>
</html>