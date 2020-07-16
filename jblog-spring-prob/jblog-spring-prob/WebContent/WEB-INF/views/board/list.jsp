<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function moveToWriteForm(){
		location.href="/jblog-spring-prob/boardWriteForm.do";
	}
	
	function doAction(boardNo,index){
		<c:choose>
		<c:when test = "${not empty user}">
			location.href="/jblog-spring-prob/boardDetail.do?type=list&no="+boardNo+"&list_idx="+index;
		</c:when>
		<c:otherwise>
			if(confirm('로그인 후 사용 가능합니다. \n 로그인 페이지로 이동하시겠습니까?'))
				location.href="/jblog-spring-prob/loginForm.do";
		</c:otherwise>
		</c:choose>
	}
	
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
	</div>
	<div id="content" align="center">
		<hr width="80%">
		<h2>자유 게시판 목록</h2>
		<hr width="80%">
		<br>
		
		<div style="padding-left: 50%;">
			<form action = "/jblog-spring-prob/selectSearch.do">
				<input type="text" name="title_search" placeholder="글 제목 입력">
				<input type="submit" value="검색">
			</form>
		</div>
		<br>

		<table style= "width:80%" border="1">
			<tr>
				<th width="8%">번호</th>
				<th width="30%">제목</th>
				<th width="15%">작성자</th>
				<th width="25%">작성일</th>
				<th width="10%">조회수</th>
				
			</tr>
			<c:forEach var="board" items="${list }" varStatus="i">
				<tr>
					<td align="center" >${i.index+1}</td>
					<td align="center">
						<a href="javascript:doAction('${ board.no}','${i.index+1}')">
							<b>${board.title}</b>
						</a>
					</td>
					<td align="center" >${board.writer }</td>
					<td align="center" >${board.reg_date }</td>
					<td align="center"> ${board.view_cnt }</td>
				</tr>
			</c:forEach>
		</table>
		<br>

		<c:if test="${ not empty user }">
			<input type="button" value="글 등록" onclick="moveToWriteForm()" />
		</c:if>

	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>

</body>
</html>