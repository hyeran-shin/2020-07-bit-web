<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/hello.do">Hello</a> <br>
	<a href="<%= request.getContextPath() %>/signUp.do">Method (signup) </a> <br>
	<a href="<%= request.getContextPath() %>/loginForm.do">Form (login) </a> <br>
	<a href="<%= request.getContextPath() %>/resBody.do">문자열 응답 </a> <br>
	<a href="<%= request.getContextPath() %>/resBody.json">JSON 응답 </a> <br>
	<a href="<%= request.getContextPath() %>/resVOBody.json">JSON(VO) 응답 </a> <br>
	<a href="<%= request.getContextPath() %>/resStrListBody.json">JSON List(문자열) 응답 </a> <br>
	<a href="<%= request.getContextPath() %>/resVOListBody.json">JSON List(VO) 응답 </a> <br>
	<a href="<%= request.getContextPath() %>/file/uploadForm.do">파일 업로드 </a> <br>
	
	<!--  
		API 만들어보기
			1. 새 프로젝트 생성
			2. id, pw, name을 저장하는 UserVO 생성
			3. UserVO들을 저장하는 리스트 생성 (임의의 시험 데이터 활용)
			4. /user/list 요청 시 모든 시험 데이터를 JSON으로 반환
				-> @ResponseBody
	 -->
</body>
</html>