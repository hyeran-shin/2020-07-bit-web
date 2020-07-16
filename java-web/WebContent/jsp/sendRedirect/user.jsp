<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String id = request.getParameter("id");
	request.setAttribute("id", id);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>${id}님이입장하셨습니다.</h3>
	<h2>전달된 파라미터 : ${param.id}</h2>
</body>
</html>