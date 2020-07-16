<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	// request : 요청 정보를 저장하는 내장 객체
	//	-> set.jsp로 넘어오는 요청 파라미터 정보를 가지고 있다.
	
	// 요청 인코딩 형식을 utf-8 설정
	request.setCharacterEncoding("utf-8");
	// 요청 파라미터 받아오기
	String cName = request.getParameter("cName");
	String cValue = request.getParameter("cValue");
	
	//콘솔 출력
	System.out.println("전달된 파라미터(cName) : " + cName);
	//쿠키 생성
	Cookie cookie = new Cookie(cName,cValue);
	// 쿠키 등록(클라이언트 접속)
// 	response.addCookie(cookie);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키 설정 완료</h2>
	<a href="get.jsp">설정된 쿠키 확인</a>
</body>
</html>