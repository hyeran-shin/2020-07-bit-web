<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		[형태]
		<c:choose>
			: if~else 또는 switch~case와 유사하게 사용
			<c:when>
				: else if 또는 case와 유사, 내부 조건을 비교
			<c:otherwise>
				: default와 유사, 조건이 만족하지 않은 경우
			</c:otherwise>
		<c:choose>
	 --%>
	<c:choose>
		<c:when test="${param.type eq 'S' }">
			<h3>관리자 입니다.</h3>
		</c:when>
		<c:when test="${param.type eq 'U' }">
			<h3>일반 사용자입니다.</h3>
		</c:when>
		<c:otherwise>
			<h4>type 파라미터가 전달되지 않았습니다.</h4>
		</c:otherwise>
	</c:choose>




</body>
</html>








