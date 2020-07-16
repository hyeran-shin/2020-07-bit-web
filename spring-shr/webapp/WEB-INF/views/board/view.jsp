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
			<div id="board" class="write-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="4">글 정보</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td style="width: 180px;">${boardVo.title }</td>
						<td class="label" style="width: 100px;">작성자</td>
							<c:choose>
								<c:when test="${boardVo.usersType.equals('admin') }">
									<td>관리자</td>		
								</c:when>
								<c:otherwise>
									<td>${boardVo.userName }</td>
								</c:otherwise>
							</c:choose>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td colspan="3">
							 ${ fn:replace(boardVo.content, newLine, "<br>") }
						</td>
						
					</tr>
				</table>
							
				<div class="bottom" style="padding-bottom: 25px;">
					<a href="${pageContext.request.contextPath }/board?p=${page}&kwd=${keyword}">글 목록</a>
					<c:if test="${not empty authUser }">
						<c:if test="${ authUser.usersType.equals('admin') and boardVo.depth == 0}">
							<a href="${pageContext.request.contextPath }/board/reply?no=${boardVo.no }&uNo=${boardVo.usersNo }&p=${page}">답글 달기</a>
						</c:if>
						
						<c:if test="${ (authUser.usersNo == boardVo.usersNo and boardVo.depth == 0) or authUser.usersType.equals('admin') }">
							<a href="${pageContext.request.contextPath }/board/modify?no=${boardVo.no }&p=${page}&kwd=${keyword}">글 수정</a>
						</c:if>
					</c:if>
				</div>
				
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>