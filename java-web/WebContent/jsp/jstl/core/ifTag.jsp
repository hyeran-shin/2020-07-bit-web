<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 	<c:set var="data" value="10"/> --%>
	<%-- 	<c:if test="${not empty data }"> --%>
	<!-- 		<h3>데이터가 존재합니다.</h3> -->
	<%-- 	</c:if> --%>


	<c:if test="${not empty param.type }">
		전달된 파라미터 : ${param.type}
		<c:if test="${param.type=='S' }">
			<h3>관리자 입니다.</h3>
		</c:if>
		<c:if test="${param.type=='U' }">
			<h3>일반 사용자입니다.</h3>
		</c:if>

	</c:if>
</body>
</html>
