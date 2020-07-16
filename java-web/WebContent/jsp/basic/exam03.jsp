<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- JSP 선언문 --%>
<%!
	// 메소드 선언(정의)
	// 두 수를 전달받아 두 수 사이의 합계 반환
	public int sum(int x, int y) {
		int temp = 0;
		for (int i = x; i <= y; i++) {
			temp += i;
		}
		return temp;
	}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	sum(1,100) : <%= sum(1,100) %>
</body>
</html>