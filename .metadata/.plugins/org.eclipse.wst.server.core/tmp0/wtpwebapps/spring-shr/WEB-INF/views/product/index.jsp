<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function productSubmit(){
		var pName = $('#productName').val();
		var pCount = $('#productCount').val();
		var pPrice = $('#productPrice').val();
		var file = $('#file').val();
		
		
		if(pName == null || pName == '' ){
			alert('상품명을 입력하세요');
			$('#productVo').val('').focus(); 
			return false;
		}
		if(pCount == null || pCount == ' ' || pCount < '1'){
			alert('수량을 1개 이상으로 입력하세요');
			$('#pCount').val('').focus(); 
			return false;
		}
		if(pPrice == null || pPrice == ' ' || pPrice < '1'){
			alert('가격을 입력하세요');
			$('#pCount').val('').focus(); 
			return false;
		}
		if(file == null || file == ' ' ){
			alert('사진을 등록하세요.');
			$('#file').val('').focus(); 
			return false;
		}
		
		
	}
</script>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<h1>상품 등록</h1>
				<form:form modelAttribute="productVo" id="search-form" method="post"  enctype="multipart/form-data"
					action="${pageContext.request.contextPath}/product">
					<table class="tbl-ex">
						<tr>
							<td style="width:100px;" class="label">상품명</td>
							<td>
								<form:input type="text"  value="" id="productName"
									style=" float: left; width: 310px;"
									path="productName" />
							</td>
							<td>
					             <spring:hasBindErrors name="productVo">
                  <c:if test="${errors.hasFieldErrors('productName')}">
                     <p style="text-align:left; color:red">
                        <spring:message code="${errors.getFieldError('password').codes[0]}" text="${errors.getFieldError('password').defaultMessage}"/>
                     </p>
                  </c:if>
               </spring:hasBindErrors>
							</td>
						</tr>
						<tr>
							<td style="width:100px;" class="label">수량</td>
							<td>
								<form:input  path="productCount" type="text" id="productCount" name="productCount" value="1" style=" float: left; width: 310px;"/></td>
							<td>
								  <p style="text-align:left; color:red">
					                  <form:errors path="productCount"/>
					               </p>
							</td>
						</tr>
						<tr>
							<td style="width:100px;" class="label">가격</td>
							<td><form:input path="productPrice" type="text" id="productPrice" name="productPrice" value="1" style=" float: left; width: 310px;" /></td>
							<td>
								  <p style="text-align:left; color:red">
					                  <form:errors path="productPrice"/>
					               </p>
							</td>
						</tr>
						<tr>
							<td style="width:100px;"  class="label">상세 설명</td>
							<td>
								<textarea id="content" name="productComment" 
								style=" float: left; width:300px; height:50px; padding: 10px; resize: none; outline: none; "></textarea>
							</td>
							<td></td>
						</tr>
						<tr>
							<td style="width:100px;" class="label">첨부파일</td>
							<td><input type="file" name="file" size="40" style="float: left;" /></td>
							<td></td> 
						</tr>
					
					</table>
					<input type="submit" value="등록" onclick="return productSubmit()" style="padding: 10px; width: 100px;">	
				</form:form>
				
				
				<table class="tbl-ex">
					<tr>
						<th>상품명</th>
						<th>사진</th>
						<th>수량</th>
						<th>가격</th>
						<th>등록일자</th>
						<th>상세보기</th>
					</tr>
					<c:forEach items="${map.list }" var="vo" varStatus="status">
						<tr>
							<td>${vo.productName}</td>
							<td height = "0">
								<div style = "height:50%">
									<img src="${pageContext.request.contextPath}/upload/${map.imageList[status.index].saveFileName}" 
										style="width:100px; height: 100px;">
								</div>
							</td>
							<td>${vo.productCount}</td>
							<td>${vo.productPrice }</td>
							<td>${vo.regDate }</td>
							<td><a href="${pageContext.request.contextPath }/product/view?productNo=${vo.productNo}&p=${map.currentPage}"> 수정 </a></td>
						</tr>
					</c:forEach> 
				</table>
				
	 			<div class="pager">
					<ul>
						<c:if test="${map.prevPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/product?
								p=${map.prevPage }"> ◀ </a></li>
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
									<li><a href="${pageContext.request.contextPath}/product?p=${page}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${map.nextPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/product?
								p=${map.nextPage }"> ▶  </a></li>
						</c:if>
					</ul>
				</div> 
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="product" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>