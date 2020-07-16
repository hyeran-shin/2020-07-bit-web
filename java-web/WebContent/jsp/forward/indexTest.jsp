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
		HTML의 페이지 이동 방식
			: JSP와 별개로 영역 공유의 개념과 관련이 없다. (form, a)
		JSP의 페이지 이동 방식
			: JSP 내장 영역에 대한 개념이 존재. (forward, sendRedirect)
		*서로 다른 기술이다.
	 -->
	<!-- HTML의 인자를 전달하여 이동하는 form tag  -->
	<form action = "forwardSet.jsp">
		아이디 입력 : <input type="text" name="id"/>
		<input type="submit" value ="전송"/>
		<!-- 
			form 내에서 입력 태그로 입력된 데이터를 가지고,
			action으로 이동해라
		 --> 
	</form>
	
</body>
</html>