<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 지시자 --%>
<%@ page import = "java.util.Enumeration" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 페이지의 헤더 이름과 값 확인
		Enumeration<String> headerEnum = request.getHeaderNames();
		while(headerEnum.hasMoreElements()){
			String headerName = headerEnum.nextElement();
			String headerValue = request.getHeader(headerName);
	%>
		<%= headerName %> : <%=headerValue %> <br>
	<%
		}
	%>
</body>
</html>