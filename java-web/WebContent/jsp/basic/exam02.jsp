<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		JSP 표현식
			- 자바 구문을 작성하는 스크립틀릿과 출력(표현)하기 위한 방법이 분리!
			- 구문은 구문 따로, 표현식은 표현식 따로 작성!
			- exam01.jsp 에서는 자바 문법으로 출력
	 --%>

	<h3>1~10까지 출력 후 합계 출력</h3>
	<%
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
// 			out.print(i + " ");
	%>
		<%= i %>
	<%
		}
// 		out.print("<br> " + sum);
	%>
	<br>
	합계 : <%= sum %>
</body>
</html>