<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/login.do" method="POST">
		아이디 : <input type="text" name="id" size="20"><br>
		비밀번호 :<input type="password" name="pw" size="20"><br>
		이름 : <input type="text" name="name" size="20" ><br>
		<input type="submit" value="전송" >
	</form>
</body>
</html>