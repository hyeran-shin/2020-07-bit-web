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
		JSP (Java Server Page)
			: HTML 문서 내에 부분적으로 Java 코드를 작성.
				-> 작성하기 위해 Scriptlet 활용!
	 --%>

	<h3>1~ 10 까지의 정수 출력</h3>
	<%
		// 자바 코드를 삽입하는 부분, 자바 주석이 가능! 
		// 스크립틀릿 작성
		for (int i = 1; i <= 10; i++) {
			out.print(i + "<br>"); // 문서에 출력(개행 태그 활용)
		}
		// out : JspWriter , JSP 내장 객체 중 하나(Built-in)
		//		-> JSP 내의 출력 스트림 객체
		// System.out.print : 콘솔에 찍힘, out.print : html 화면에 찍힘
	%>
</body>
</html>