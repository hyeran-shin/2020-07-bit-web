<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%
	String[] members = {"임영웅","김수찬","정동원","영탁"};
	//el로 쓸거라 현재 페이지에 등록시켜줌
	pageContext.setAttribute("members", members);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--배열 순회 --%>
	<c:forEach var="element" items="${members }">
		${element}
	</c:forEach>
	<%--
		for(String element : members){
			out.print(element)
		} 와 같다.
	 --%>
	 
	 <br>
	 <%-- 구분자 넣기 --%>
	 <c:set var="cnt" value="1"/>
	 <c:forEach var="element" items="${members }">
	 	<c:if test="${cnt ne 1 }">, </c:if>
	 	${element }
	 	<c:set var="cnt" value="${cnt +1 }"/>
	 </c:forEach>
	 <br>
	 <c:forEach var="element" items="${members }" varStatus="loop">
	 	<c:if test="${loop.count ne 1 }">, </c:if>
	 	${element }
	 </c:forEach>
	 
	 <hr>
	 <%-- 일반 for 반복문처럼 사용, 위에는 전체 다 순회 , 지금은 10번만 뭐 숫자 지정--%>
	 1~10까지의 정수 출력 <br>
	 <c:forEach var="i" begin="1" end="10" >${i} </c:forEach>
	 
	 <br>
	 
	 1~100까지의 정수 합계 출력<br>
	 <c:set var = "sum" value="0"/>
	 <c:forEach var="i" begin="1" end="100" >
	 	<c:set var="sum" value="${sum+i}"/>
	 </c:forEach>
	 합계 : ${sum }
	 
	 <br>
	 
	 1~100까지의 홀수 합계 출력<br>
	 <c:set var = "sum" value="0"/>
	 <c:forEach var="i" begin="1" end="100" step="2"> <%--step : 증가--%>
	 	<c:set var="sum" value="${sum+i}"/>
	 </c:forEach>
	 합계 : ${sum }
	 <br>
	 <%--반복적인 요소 작성 시 많이 활용 --%>
	연도 선택 : 
	<select>
		<c:forEach var="year" begin="1970" end="2020">
			<option>${year }</option>
		</c:forEach>
<!-- 		<!-- 코드양이 너무 늘어난다.--> 
<!-- 		<option>1970</option> -->
<!-- 		<option>1971</option> -->
<!-- 		<option>...</option> -->
<!-- 		<option>2019</option> -->
<!-- 		<option>2020</option> -->

	</select>	 
</body>
</html>









