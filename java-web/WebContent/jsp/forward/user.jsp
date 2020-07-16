<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- EL : 영역의 데이터를 표현하기 위한 방법  -->
	<h2>${id}님이 입장하셨습니다.</h2>
	<h2>${uid}님이 입장하셨습니다.</h2>
	<!-- EL : 영역의 데이터를 표현하기 위한 방법  -->
	<h2>전달된 파라미터 : ${param.uid}님이 입장하셨습니다.</h2>
	
	<h2>param : ${param.id}님이 입장하셨습니다.</h2>
	<h2>request : <%=request.getParameter("uid") %>님이 입장하셨습니다.</h2>

	<!--  
		param.id와 parai.uid 둘 다 해도 나옴.
		get방식으로 html에 남아있을 때만 사용 가능
		forward는 url에서 파라미터 값을 넘김 (forwardSet.jsp?id=yes) 
		user.jsp 에서는 indexText.jsp에서 id 값도 받고, 
		forwardSet.jsp에서 uid값을 받는다.
	 -->
</body>
</html>