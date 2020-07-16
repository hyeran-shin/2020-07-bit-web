<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
		forwardSet.jsp에서 이동!
		a 태그 (HTML의 이동 방식) - 영역을 공유하지 않는다.
	-->
	id : ${id} <br>	<!-- 영역을 공유하지 않는다. -->
	param.id : ${param.id}
	<!-- 
		html 문서상 id라는 데이터가 존재하지 않는다. 
		forwardSet.jsp?id=yes처럼 데이터가 없기에, 출력되지 않는다.
	-->
</body>
</html>