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
		forwardSet.jsp에서 forward방식으로 이동 - 영역을 공유
	 -->
	<h2>관리자님이 입장하셨습니다.</h2>
	<h2>tid : ${tid}</h2> <!-- 영역에 존재하는 데이터를 출력 -->
	
	<h2>param.id : ${param.id}</h2> <!-- 문서상에서 뽑는 방법  -->
	<h2>param.tid : ${param.tid}</h2> <!-- 문서상에서 뽑는 방법  -->
	<!-- Html 문서상에 tid라는 파라미터가 존재하지 않는다. -->
</body>
</html>