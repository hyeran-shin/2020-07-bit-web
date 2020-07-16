<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<c:choose>
				<c:when test="${authUser.usersType.equals('admin') }">
			
					<form class="write-form" method="post"
						action="${pageContext.request.contextPath }/board/write">
						<input type="hidden" name="groupNo" value="${boardVo.groupNo}"/>
						<input type="hidden" name="orderNo" value="${boardVo.orderNo}"/>
						<input type="hidden" name="depth" value="${boardVo.depth}"/>
						<input type="hidden" name="no" value="${boardVo.no}"/>
						<input type="hidden" name="boardPublic" value="${boardVo.boardPublic}"/>
						<input type="hidden" name="p" value="${page}"/>
						<input type="hidden" name="uNo" value="${uNo}">
						<table class="tbl-ex">
							<tr>
								<th colspan="2"> 답글 작성  </th>
							</tr>
							<tr>
								<td class="label">제목</td>
								<td><input type="text" name="title" value=""></td>
							</tr>
							<tr>
								<td class="label">내용</td>
								<td>
									<textarea id="content" name="content"></textarea>
								</td>
							</tr>
						</table>
						
						<div class="bottom">
							<a href="javascript:history.go(-1)">취소</a>
							<input type="submit" value="등록">
						</div>
					</form>
				</c:when>				
				<c:otherwise>
					<h2>권한이 없습니다.</h2>
				</c:otherwise>
			</c:choose>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>