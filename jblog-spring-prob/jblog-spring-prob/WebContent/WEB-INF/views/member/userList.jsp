<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="header">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
	</div>
	<div id="content">

		<hr width="80%">
		<h2>회원 목록</h2>
		<hr width="80%">
		<br>

		<table style= "width:80%" border="1">
			<tr>
				<th width="15%">아이디</th>
				<th width="10%">이름</th>
				<th width="15%">비밀번호</th>
				<th width="20%">전화번호</th>
				<th width="5%">등급</th>
				<th width="15%">가입일</th>
			</tr>

			<c:forEach var="member" items="${list}">
				<tr>
					<td align="center">${member.id}</td>
					<td align="center">
						<a href="/jblog-spring/userDetail.do?id=${member.id}"> 
							<c:out	value="${member.name}" />
						</a>
					</td>
					<td align="center">${member.password}</td>
					<td align="center">${member.tel1}-${member.tel2}-${member.tel3}</td>
					<td align="center">${member.type}</td>
					<td align="center">${member.reg_date}</td>
				</tr>
			</c:forEach>
		</table>

	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>







