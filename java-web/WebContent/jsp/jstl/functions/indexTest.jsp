<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		functions 
			- prefix : fn
			- EL에서 사용할 수 있는 함수 제공
				length, toUpperCase, toLowerCase,
				substring, trim, indexOf, contains, ... 
	 --%>
	 
	<c:set var="str" value="Hello Functions"/>
	fn:length{"Hello Functions"} : ${fn:length(str)}<br>
	fn:substring{ ("Hello Functions" , 1, 7 )} : ${fn:substring(str,1,7) }<br>
	 
	 
</body>
</html>






