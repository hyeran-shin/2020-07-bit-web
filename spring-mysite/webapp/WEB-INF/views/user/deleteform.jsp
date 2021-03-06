<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">
				<p class="join-success">	
					탈퇴 완료 <br><br>
				</p>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
     	<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>