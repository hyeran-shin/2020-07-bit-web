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
	<%--
		JSTL(JSP Standatd Tag Library)
			- JSP 표준 태그 제공
			- JSP만의 기능을 가진 태그를 추가하여 사용 가능
		
		Core (prefix : c, url : http://java.sun.com/jsp/jstl/core)
			- 일반 프로그래밍에서 사용하는 기능 제공
			- 변수, 실행흐름의 컨트롤, 페이지 이동 등의 기능 제공
	 --%>

	pageContext 영역에 10값을 가지는 변수 cnt 등록 :
	<c:set var="cnt" value="10" />
	${cnt }
	<br>

	<%-- cnt 값을 1 증가 후 출력 :
	<c:set var="cnt" value="${ cnt + 1 }" />
	${cnt} <br>
	<c:set var="cnt" value=" ${ cnt + 1 } " /> <!-- 양쪽 공백이 존재 -->
	${cnt} <br> " 12 " (양쪽 공백이 포함된 문자열 형태)
	<c:set var="cnt" value="${ cnt + 1 } " /> <!-- 문자열과 정수의 + 연산 -->
	${cnt} --%> <br> <%-- " 12 " + 1 (타입 불일치 예외 발생) --%>
	<%--
		value 속성의 값을 cnt에 적용하는데, 양쪽 공백까지 같이 적용
		문자열 데이터로 값이 저장
		문자열 데이터와 정수 데이터 연산 시 예외 발생
		
		EL에서의 연산은 정수만 가능하다.
	 --%>
	
	<%-- 예외 발생 예시 --%>
	<c:set var="str1" value="Hello" />
	<c:set var="str2" value="JSTL" />
<%-- 	<c:set var="result" value="${str1+str2}" /><!-- 오류남 --> --%>
<%-- 	<c:set var="result" value="${str1+ '-' + str2}" /><!-- 오류남 --> --%>
	<c:set var="result" value="${str1} - ${str2}" />
	${result} 
	<br>
	
	<%-- request 영역에 등록 --%>
	<c:set var="cnt" value="10"/> <%-- 다시 초기화 --%>
	<c:set var="cnt" value="${cnt+1}" scope="request"/>
	pageContext 영역 : ${cnt} <br>
	request 영역 : ${requestScope.cnt}<br>
	
</body>
</html>






