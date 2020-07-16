<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html>
<%--
	세션(Session)
		1. 클라이언트와 웹 서버간 연결이 유지되고 있는 상태
		2. 유저가 웹 브라우저를 통해 웹 서버 접속 후 종료할 때 까지의 상태
		3. 클라이언트가 웹 서버에 요청시(접속시) 서버는 클라이언트에게 ID를 부여(JSESSIONID)
		4. ID는 임시로 저장되어 (클라이언트가 재접속) 또는 (페이지 이동) 시에 
		      서버가 클라이언트를 식별하는 수단으로 사용
		
		[장점]
		 - 클라이언트별 맞춤 서비스 제공이 가능
		 - 클라이언트의 사용 정보를 서버에 저장하기에 보안 측면에서 쿠키보다 뛰어남
		[단점]
		 - 정보들을 서버에 저장하기에 해당 데이터 처리에 대한 비용 발생
 --%>
<%
	// 세션의 유효 시간
	int interval = session.getMaxInactiveInterval();
	String id = session.getId(); //JSESSION
	
	// 세션 유효시간 변경
	session.setMaxInactiveInterval(3);
	int interval2 = session.getMaxInactiveInterval();
	// 	request.setAttribute("id", id);
	// 	pageContext.setAttribute("id",id);
	//마지막 접속 시간
	long lastTime = session.getLastAccessedTime();
	Date d = new Date(lastTime);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
${} : el, <%= %> : jsp 표현식
	el은 데이터가 없다면(null) 출력되지 않는다.
	- el은 영역을 탐색, 스크립틀릿으로 선언한 배열을 영역에 등록하지 않으면 사용 불가.
 --%>
	<h2>세션 ID (JSESSION) : ${id}</h2>
	<h2>세션 ID (JSESSION) : <%=id %></h2>
	<h2>세션의 기존 유효시간 : <%= interval %></h2>
	<h2>세션의 변경 유효시간 : <%= interval2 %></h2>
	<h2>마지막 접근 시간 : <%= sdf.format(d) %></h2>
</body>
</html>