<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">	
	function c_delete(boardNo, commentNo,list_idx){
		if(confirm('삭제 하시겠습니까?')){
			location.href="/jblog-spring-prob/commentDelete.do?no="
					+ boardNo+"&c_no="+ commentNo+"&list_idx="+list_idx;
		}
	}
</script>
<body>
	<form action="/jblog-spring-prob/comment.do" method="post">
		<table style="width :80%">
			<tr>
				<td><strong>댓글</strong></td>
			</tr>
			<tr>
				<td width="70%"><textarea
						style="width: 99%; height: 70px; resize: none;" rows="4"
						placeholder="댓글을 입력하세요" id="comment" name="comment_content"></textarea></td>
				<td width="10%" align="center"> 
					<input type="hidden" value="${list_idx}" name="list_idx">
					<input type="submit" value="등록"
					 id="comment_btn" 
					 onclick="javascript:form.action='/jblog-spring-prob/commentInsert.do';"
					 style="width: 100%; height: 75px; padding: 20px; margin: 0px">
				</td>
			</tr>
			<c:forEach var="list" items="${commentList }">
				<tr>
					<td id="comment_id" colspan="2">
					<hr>
					<span><strong> ${list.comment_id} </strong><small> ${list.comment_reg_date}</small></span>
					 </td>
				</tr>
				<tr>
					<td id="comment_content" colspan="">${list.comment_content }</td>
					<c:if test="${user.id eq list.comment_id}">
						<td>
							<a href="#" onclick="c_delete('${list.boardNo }','${list.commentNo}','${list_idx}')">삭제</a> 
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>