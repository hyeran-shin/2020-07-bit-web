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
		EL (Expression Language)
			: JSP 표현식을 더 간결하게 활용
			
		산술 연산 : +, -, *, /(div), %(mod)
		관계 연산 : ==(eq), !=(ne), <(lt), >(gt), <=(le), >=(ge)
		논리 연산 : &&(and), ||(or), !(not)
		
		${표현식} -> 표현식 하나의 단위(수행 구문)
	 --%>

<%-- 	7+3 : <%=7+3 %>	<br> --%>
<%-- 	7+3 : ${7+3 }	<br> --%>
<%-- 	7%3 : ${7%3 }	<br> --%>
<%-- 	7 mod 3 : ${7 mod 3 }	<br> --%>
<%-- 	7 == 3 : ${7 ==3}	<br> --%>
<%-- 	7 eq 3 : ${7eq 3 }	<br> --%>
<%-- 	7!=3 : ${7 !=3 }	<br> --%>
<%-- 	7 ne 3 : ${7 ne 3 }	<br> --%>
<%-- 	(4==4) && (7>3) : ${(4==4) && (7<3) }	<br> --%>
<%-- 	(4 eq 4) and (7 gt 3) : ${ (4 eq 4) and (7 gt 3)} <br> --%>
<%-- 	empty str : ${empty str }	<br> --%>
<%-- 	not empty str : ${not empty str }	<br> --%>
<!-- 	7 % 3 == 0 ? "3의 배수 입니다." : "3의 배수가 아닙니다." <br> -->
<%-- 	결과 : ${( 7 % 3 == 0) ? "3의 배수 입니다." : "3의 배수가 아닙니다."} <br> --%>
	
	
	
	
	
</body>
</html>