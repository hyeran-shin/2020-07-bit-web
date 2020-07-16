<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("newLine", "\n"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">

	function orderSubmit(no, name, index){
		var count = $('#countBtn'+index).val();
	 	location.href = '${pageContext.request.contextPath}/order/ok?pNo=' + no +'&pName=' + name + '&pCount=' + count;
	}
	
	function openWin(ono, uno){  
	    window.open("${pageContext.request.contextPath}/order/view?oNo="+ono+"&uNo="+uno,
	    		"상세보기", "width=800, height=500, left=500, top=100, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
	}  



	
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<h1>주문 현황</h1>
				<form id="search-form" method="get"
					action="${pageContext.request.contextPath}/order/status">
					<input type="text" id="kwd" name="kwd" value="${order_map.keyword }">
					<input type="submit" value="검색">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>순번</th>
						<th>상품명</th>
						<th>수량</th>
						<th>가격</th>
						<th>주문일자</th>
						<th>사용자</th>
						<th>상세보기</th>
					</tr>
					<c:forEach items="${order_map.list }" var="vo" varStatus="status">
						<tr>
							<td>${order_map.totalCount - (order_map.currentPage -1) * order_map.listSize - status.index }</td>
							<td>${vo.product_name}</td>
							<td>${vo.order_product_count}</td>
							<td>${vo.order_product_price }</td>
							<td>${vo.order_date }</td>
							<td>${vo.users_name }</td>
							<td><a href="" onclick="openWin('${vo.no}', '${vo.users_no}')" >상세보기</a></td>
						</tr>
					</c:forEach> 
				</table>
				<form action="">
				<input type="submit" value="목록" onclick="location.href='${pageContext.request.contextPath}/order/status'"
						  style="padding: 10px; margin: 0 250px;"></form>
	 			<div class="pager">
					<ul>
						<c:if test="${order_map.prevPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/order/status?
								p=${order_map.prevPage }"> ◀ </a></li>
						</c:if>
						
						<c:forEach begin="${order_map.beginPage }" end="${order_map.beginPage + order_map.listSize -1 }" var="page">
							<c:choose>
								<c:when test="${order_map.endPage < page }">
									<li>${page}</li>
								</c:when>
								<c:when test="${order_map.currentPage == page }">
									<li class="selected" > ${page }</li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.request.contextPath}/order/status?p=${page}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${order_map.nextPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/order/status?
								p=${order_map.nextPage }"> ▶  </a></li>
						</c:if>
					</ul>
				</div> 
		
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="orderStatus" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>