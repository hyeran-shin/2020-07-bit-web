<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>파일 업로드</h3>
	<form action="<%= request.getContextPath() %>/file/upload.do" 
			method="POST" enctype="multipart/form-data">
		<input type="text" name="id" value="test"><br>
		<input type="file" name="attachFile01"><br>
		<input type="file" name="attachFile02"><br>
		<input type="submit" value="업로드">
	</form>
</body>
</html>
		