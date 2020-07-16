<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	value 속성만 지정 : <c:out value="JSTL" /><br>
	value 속성 값이 없는 경우 (default) : 
	<c:out value="${msg}" default="msg가 영역에 존재하지 않습니다."/><br>
	HTML 요소를 포함하는 경우 : 
	<c:out value="<hr>"/> <br>
	HTML 요소를 포함하는 경우 (escapeXml = "false") : 
	<c:out value="<hr>" escapeXml="false"/><br>
	<%-- 
		기본적으로 escapeXml 속성의 값은 true
		자바에서 쓰는 이스케이프(\~)를 탈출해라(false)
		HTML 요소 기능을 표현하려면 escapeXml 속성을 false로 지정
		
		XML (Extendsible Mark-up Language)
			- 데이터 처리를 위해 확장된 언어
			- HTML은 문서를 표현하는데 주로 사용되지만, 
			  XML은 "데이터 저장 양식"으로도 활용
		
	 --%>
</body>
</html>