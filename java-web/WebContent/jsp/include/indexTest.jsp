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
		include directive (디렉티브)
			다른 파일을 삽입하여, 
			JSP를 Java로 변환 후 컴파일 동작한다.
			- 하나의 페이지라고 생각 (pageContext 동일)
			- 변화하지 않는, 고정적인 문서를 포함시킬 때 활용
	 --%>

	<h2>정적인 include</h2>
	<%-- 	<%= msg %>  include 하기 전 사용하면 오류남 --%>
	<%-- include 전, 수행 전에는 msg 사용 불가 --%>
	<%@ include file="directive.jsp"%>
	<%= msg %>
	${ directive } 
	<%-- 위에 코드가 있다고 생각, pageContext 영역 같이 사용 --%>
	<%-- directive.jsp 영역에 등록한 directive를 출력하라. (EL) --%>
	
	
	<hr>
	
	
	<%--
	 	include action(액션)
	 		include 요청 시 실행흐름을 옮겨가, 
	 		해당 파일의 결과를 현 위치에 포함시킨다.
	 		- 서로 다른 페이지라고 생각, 단순히 실행 흐름을 잠시 옮겨간다.
	 		- 특정 데이터에 따라 동적으로 변화시킬 때 활용
	  --%>


	<h2>동적인 include</h2>
	<!-- 전달 파라미터 설정하지 않은 경우 -->
	<jsp:include page="action.jsp"/>
	<%-- 파라미터 설정(include 시 파라미터 전달, 페이지 이동) --%>
	<jsp:include page="action.jsp" >
		<jsp:param name="id" value="Actiong include!!!"/>
	</jsp:include>
	${action}
	
</body>
</html>





