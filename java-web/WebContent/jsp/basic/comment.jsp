<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP 주석, 주석 구문 삽입
		[JSP 태그 종류] : HTML에 삽입하기 위한 방법 (문법)
		<% %> 		: JSP 스크립틀릿, Java 구문을 JSP에 삽입
		<%= %>		: JSP 표현식, Java 표현식을 문자열로 출력
		<%! %>		: JSP 선언문, 인스턴스 변수 및 메소드 선언
		<%@ %> 		: JSP 지시자 , JSP 자체 적용할 조건 설정
	--%>
	
	<%-- 
		JSP 주석
			문서에 자바 코드가 삽입 -> 자바 실행 황경이 필요
			자바 코드는 서블릿을 통해 실행된다. 
			서블릿으로 변환되지 않기에, 
			페이지 소스에 존재하지 않는다.
	 --%>
	<!-- 
	 	HTML 주석
	 		서블릿으로 변환되어 결과가 화면에 전달은 되지만, 
	 		브라우저 문서 구조를 나타내는 HTML의 주석 역할로
	 		브라우저 화면에는 출력하지 않는다.
	 		페이지 소스에 존재한다.
	  -->

	Hello JSP!!!
	
</body>
</html>