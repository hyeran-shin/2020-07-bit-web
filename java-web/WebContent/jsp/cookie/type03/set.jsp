<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--
	contentType 	-> 서버단에서 사용될 HTML의 Encoding
	pageEncoding	-> JSP 페이지 내에서 사용될 Encoding
	<html>안에 있는 <meta charset="UTF-8"> 메타데이타 : 데이터 안의 데이터 
--%>
<%@ page import="java.net.URLEncoder"%>
<!DOCTYPE html>
<%
	// request : 요청 정보를 저장하는 내장 객체
	//	-> set.jsp로 넘어오는 요청 파라미터 정보를 가지고 있다.

	// 요청 인코딩 형식을 utf-8 설정
	request.setCharacterEncoding("utf-8");

	// 요청 파라미터 받아오기
	// 파라미터 추출 후 쿠키에 저장하기 위한 인코딩 작업
	// 파라미터 자체의 encode를 utf-8로 설정 
	String cName = request.getParameter("cName");
	cName = URLEncoder.encode(cName, "utf-8");
	String cValue = request.getParameter("cValue");
	cValue = URLEncoder.encode(cValue, "utf-8");

	String cAge = request.getParameter("cAge");

	//콘솔 출력
	System.out.println("전달된 파라미터(cName) : " + cName);
	//쿠키 생성
	Cookie cookie = new Cookie(cName, cValue);

	//생성된 쿠키의 유효시간 설정 -> setMaxAge(...)
	if (cAge != null && cAge.length() > 0) { //문자열
		cookie.setMaxAge(Integer.parseInt(cAge)); // 최대 시간 설정
	}

	// 쿠키 등록(클라이언트 접속)
	response.addCookie(cookie);
%>
<html>
<head>
<meta charset="UTF-8">
<!-- 현재 HTML문서의 대한 Encoding -->
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 설정 완료</h2>
	<a href="get.jsp">설정된 쿠키 확인</a>
</body>
</html>