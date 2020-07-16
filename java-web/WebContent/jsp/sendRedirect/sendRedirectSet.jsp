<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	request.setAttribute("id", request.getParameter("id"));
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- SendRedirect 방식으로 이동 시 스크립틀릿 활용 -->
		<% response.sendRedirect("admin.jsp");%>
	<!-- 유저에게 응답으로 admin.jsp로 이동시키겠다. -->

	<!-- 파라미터를 포함하여 이동 -->
	<%
		//forward(액션태그)처럼 파라미터를 포함하여 전달하는 방법이 없기에,
		//URL에 파라미터 정보를 포함하는 get 방식을 흉내
		//URL의 ?기호 이후는 GET 전송의 파라미터 형식임을 활용.
// 		String path = "user.jsp?id=" + request.getParameter("id");
// 		response.sendRedirect(path); //user.jsp?id=yes
	%>
</body>
</html>