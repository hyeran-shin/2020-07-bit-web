<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		HTTP의 특징
			Connection-less
			 - 클라이언트의 request를 서버에 보내고,
			      서버는 클라이언트에게 response를 보내면,
			      연결이 끊기는 특징을 가지고 있다.
			      
			State-less
			 - 접속을 끊는 순간 서버와의 통신 유지가 사라지는 특징
			 
		쿠키(Cookie)
			1. HTTP의 일종으로 클라이언트에 데이터를 저장하는 방식
			2. Login, Host 정보 등을 저장
	 -->
	 
	 <!-- cName, cValue 파라미터 이름으로 입력된 값을 Post 방식으로 set.jsp 전송 -->
	 <form action="set.jsp" method="post">
	 	Cookie Name : <input type="text" name="cName" size=20><br>
	 	Cookie Value : <input type="text" name="cValue" size=20><br>
	 	유효시간 (초) : <input type="text" name="cAge" size=20><br>
	 	<input type="submit" value="쿠키 설정">
	 </form>
</body>
</html>