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
<link href="${pageContext.request.contextPath}/assets/css/gallery.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">

	function orderSubmit(no, name, index, price){
		var count = $('#countBtn'+index).val();
		var p = count * price;
	 	location.href = '${pageContext.request.contextPath}/order/ok?pNo='
	 			+ no +'&pName=' + name + '&pCount=' + count +'&price=' + p;
	}
	
</script>
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<h1>상품 리스트</h1>
				<form action="" method="post" >
					<table class="tbl-ex">
					<tr>
						<th>상품명</th>
						<th>사진</th>
						<th>수량</th>
						<th>가격</th>
						<th>담기</th>
					</tr>
					<c:forEach items="${map.list }" var="vo" varStatus="status" >
						<tr>
							<td>${vo.productName}</td>
							<td height = "0">
								<div style = "height:50%">
									<img src="${pageContext.request.contextPath}/upload/${map.imageList[status.index].saveFileName}" 
										style="width:100px; height: 100px;">
								</div>
							</td>
							<td><input type="number" min ="1" id="countBtn${status.index}"  value="1" style="width: 30px; text-align: center;"></td>
								<td>${vo.productPrice }</td>
								<td><input type="button" value="담기"
									style="padding: 5px; border: 1px solid #aaa; background-color: #aaa; font-weight: bold; color: #fff;"
									onclick="orderSubmit('${map.list[status.index].productNo}', '${map.list[status.index].productName}','${status.index }','${map.list[status.index].productPrice}')"></td>
							</tr>
					</c:forEach> 
					</table>
				</form>
				
	 			<div class="pager">
					<ul>
						<c:if test="${map.prevPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/order?
								p=${map.prevPage }&op=${order_map.currentPage}"> ◀ </a></li>
						</c:if>
						
						<c:forEach begin="${map.beginPage }" end="${map.beginPage + map.listSize -1 }" var="page">
							<c:choose>
								<c:when test="${map.endPage < page }">
									<li>${page}</li>
								</c:when>
								<c:when test="${map.currentPage == page }">
									<li class="selected" > ${page }</li>
								</c:when>
								<c:otherwise>
									<li><a href="${pageContext.request.contextPath}/order?p=${page}&op=${order_map.currentPage}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${map.nextPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/order?
								p=${map.nextPage }&op=${order_map.currentPage}"> ▶  </a></li>
						</c:if>
					</ul>
				</div> 
		
				<h1>주문요청</h1>
				<table class="tbl-ex">
					<tr>
						<th>상품명</th>
						<th>수량</th>
						<th>가격</th>
						<th>등록일자</th>
						<th>삭제</th>
					</tr>
					<c:forEach items="${order_map.list }" var="vo" varStatus="status">
						<tr>
							<td>${vo.product_name}</td>
							<td>${vo.order_product_count}</td>
							<td>${vo.order_product_price}원</td>
							<td>${vo.order_date }</td>
							<td><a href="${pageContext.request.contextPath }/order/delete?pNo=${vo.product_no}&no=${vo.no}"> 삭제 </a></td>
						</tr>
					</c:forEach> 
				</table>
					
	 			<div class="pager">
					<ul>
						<c:if test="${order_map.prevPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/order?
								op=${order_map.prevPage }&p=${map.currentPage}"> ◀ </a></li>
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
									<li><a href="${pageContext.request.contextPath}/order?op=${page}&p=${map.currentPage}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${order_map.nextPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/order?
								op=${order_map.nextPage }&p=${map.currentPage}"> ▶  </a></li>
						</c:if>
					</ul>
				</div> 
		
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="order" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>