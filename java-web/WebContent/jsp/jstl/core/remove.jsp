<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	pageContext 영역에 data 설정 : 
	<c:set var="data" value="1"/>
	${data }<br>
	request 영역에 data 설정 : 
	<c:set var="data" value="${data+1}" scope="request"/>
	${requestScope.data } <br>
	
	<%-- pageContext 영역 data 삭제 --%>
<%-- 	<c:remove var="data" scope="page"/> --%>
	<%-- request 영역 data 삭제 --%>
	<c:remove var="data" scope="requset"/>
	pageContext : ${pageScope.data}<br>
	request : ${requestScope.data}<br>
</body>
</html>
