<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<!DOCTYPE html>
<%
// 	String[] members = {"임영웅","정동원","김수찬","영탁"};
	String[] members = new String[4];
	//pageContext 영역에 등록 // NULL String[]
	pageContext.setAttribute("members", members);
	// 이름 : "members", 값 : String 객체
	
	Map<String,String> employees = new HashMap<>();
	employees.put("e1001","강동원");
	employees.put("e1002","정우성");
	
	pageContext.setAttribute("employees",employees);
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	JSP 표현식 활용 <br>
 	1번 회원 : <%= members[0]%> <br>
 	2번 회원 : <%= members[1]%> <br>
 	3번 회원 : <%= members[2]%> <br>
 	4번 회원 : <%= members[3]%> <br><br>
 	<!--  스크립틀릿으로 선언한 배열의 데이터를 바로 표현 가능 -->
 	
	<!--  el은 데이터가 없다면(null 값을 가지고 있으면) 출력되지 않는다. -->
 	EL 활용<br>
 	1번 회원 : ${members[0]} <br>
 	2번 회원 : ${members[1]} <br>
 	3번 회원 : ${members[2]} <br>
 	4번 회원 : ${members[3]} <br><br>
 	<!--  EL은 영역을 탐색 
 		스크립틀릿으로 선언한 배열을 영역에 등록하지 않으면 사용 불가. (접근 X)
 	-->
 	
 	Map 객체 표현<br>
 	<!-- JSP 표현식 : 자바 코드로 삽입된 것을 접근한다. -->
 	직원 (e1001) : <%=employees.get("e1001") %> <br>
 	직원 (e1002) : <%=employees.get("e1002") %> <br>
 	<!-- EL 표현식 : 영역에 등록된 데이터를 접근 -->
 	직원 (e1001) : ${employees.e1001} <br>
 	직원 (e1002) : ${employees.e1002} <br>
</body>
</html>




