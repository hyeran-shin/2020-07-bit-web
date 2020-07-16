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
				<h1>질문 게시판 </h1>
				<form class="write-form" method="post" action="${pageContext.request.contextPath }/board/write">
					<table class="tbl-ex">
						<tr>
							<th colspan="2"> 글쓰기  </th>
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
						<tr>
							<td class="label" >공개 여부</td>
							<td>
								<input type="radio" value="1" name="boardPublic" checked> 공개
								<input type="radio" value="0" name="boardPublic"> 비공개
							</td>
						</tr>
					</table>
					
					<div class="bottom" style="padding-bottom: 25px;">
						<a href="${pageContext.request.contextPath }/board/" style="margin-bottom: 10px">취소</a>
						<input type="submit" value="등록" style="margin-bottom: 10px">
					</div>
				</form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" >
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>