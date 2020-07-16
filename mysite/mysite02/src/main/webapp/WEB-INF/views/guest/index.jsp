<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% pageContext.setAttribute("newLine", "\n"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="board">
				<h1>방명록</h1>
				<form id="search-form" method="post" action="${pageContext.request.contextPath}/guest">
					<table class="tbl-ex">
						<tr>
							<td style="width:100px;" class="label">작성자</td>
							<c:choose>
									<c:when test="${not empty authUser}">
										<td><label style="float:left;">${authUser.name }</label></td>
										<input type="hidden" name="writer" value="${authUser.name }" >
									</c:when>
									<c:otherwise>
										<td><input type="text" name="writer" value="" style=" float: left;"></td>
									</c:otherwise>
									</c:choose>
							<td></td>
						</tr>
						<tr>
							<td style="width:100px;"  class="label">내용</td>
							<td>
								<textarea id="content" name="content" 
								style=" float: left; width:300px; height:50px; padding: 10px; resize: none; outline: none; "></textarea>
							</td>
							<td> <input type="submit" value="등록" style="padding: 25px;"> </td>
						</tr>
					</table>
				</form>
				
				
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th style="width : 50%">내용</th>
						<th>글쓴이</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${map.list }" var="vo" varStatus="status">
						<tr>
							<td>${vo.no}</td>
							<td>${ fn:replace(vo.content, newLine, "<br>") }</td>
							<td>${vo.writer }</td>
							<td>${vo.regDate }</td>
							<td></td>
						</tr>
					</c:forEach>
				</table>
				
				<div class="pager">
					<ul>
						<c:if test="${map.prevPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/guest?
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
									<li><a href="${pageContext.request.contextPath}/guest?p=${page}">${page}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						
						<c:if test="${map.nextPage > 0 }">
							<li><a href="${pageContext.request.contextPath }/guest?
								p=${map.nextPage }"> ▶  </a></li>
						</c:if>
					</ul>
				</div>
				
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="guest" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>