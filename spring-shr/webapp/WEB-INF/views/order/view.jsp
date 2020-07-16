<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/gallery.css"	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="board">
		<h1 style="float:left; padding-bottom: 20px;">사용자 정보</h1>
		<form action="" method="post" style="padding-bottom: 20px;" >
			<table class="tbl-ex" >
				<tr>
					<th>성명</th>
					<th>이메일</th>
					<th>성별</th>
					<th>가입일</th>
				</tr>
				
				<tr>
					<c:forEach items="${list }" var="vo" >
						<td>${vo.users_name }</td>
						<td>${vo.email }</td>
						<td>${vo.gender }</td>
						<td>${vo.reg_date }</td>
					</c:forEach>
				</tr>
			</table>
		</form>
		
		
		<h1 style="float:left; padding-bottom: 20px;" >주문 정보</h1>
		<form action="" method="post" style="padding-bottom: 20px;">
			<table class="tbl-ex">
				<tr>
					<th>상품명</th>
					<th>주문수량</th>
					<th>총 가격</th>
					<th>주문일자</th>
				</tr>
				<tr>
					<c:forEach items="${list}" var="vo" >
						<td>${vo.product_name }</td>
						<td>${vo.order_product_count }</td>
						<td>${vo.order_product_price }</td>
						<td>${vo.order_date }</td>
					</c:forEach>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>