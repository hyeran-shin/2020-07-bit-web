<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head> 
<body>
	<div id="header">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
	</div>
	<div id="content" align="center">
		<hr width="80%">
		<h2>게시물 상세 정보</h2>
		<hr width="80%">
	<form method="post" name="form">
		<table style="width:80%" border="1">
			<tr>
				<th width="15%">글 번호</th>
				<td width="15%">${list_idx }</td>
				<th width="15%" >작성일</th>
				<td width="15%" >${board.reg_date }</td>
			</tr>
			<tr>
				<th width="15%">작성자</th>
				<td width="15%">${board.writer }</td>
				<th width="15%">조회수</th>
				<td width="15%">${board.view_cnt }</td>
			</tr>
			<tr>
				<th width="15%">제목</th>
				<td colspan="5">${board.title }</td>
			</tr>
			<tr>
				<th width="15%">첨부파일</th>
				<td colspan="5"><c:forEach var="file" items="${fileList }">
						<a target="blank"
							href="/jblog-spring-prob/upload/${file.fileSaveName }"
							download="${file.fileOriName }"> ${file.fileOriName} </a>
						&nbsp; (${file.fileSize } byte)
						<br>
					</c:forEach></td>
			</tr>
			<tr>
				<th width="15%" height="100px">내용</th>
				<td colspan="5">${board.content }</td>
			</tr>
			<tr>
		</table>
		<br>

		<c:if test="${board.writer eq user.id }">
			<input type="submit" value="수정" style="padding: 10px; width : 10%;"
				onclick="javascript:form.action='/jblog-spring-prob/boardModifyForm.do?no=${board.no}&list_idx=${list_idx }';">
			&nbsp;
			<input type="submit" value="삭제" style="padding: 10px; width : 10%;"
				onclick="javascript:form.action='/jblog-spring-prob/boardDelete.do?no=${board.no}&list_idx=${list_idx }';" >
		</c:if>
		&nbsp;
		<input type="button" value="목록" style="padding: 10px; width : 10%;"
				onclick="javascript:location.href='/jblog-spring-prob/boardList.do'">
		<br>
		
		<hr width="80%">
		<input type="hidden" name="board_no" value='${board.no }'> 
		<input type="hidden" name="comment_id" value='${user.id }'> 
		<jsp:include page="/WEB-INF/views/board/commentForm.jsp" />
		</form>	
	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>