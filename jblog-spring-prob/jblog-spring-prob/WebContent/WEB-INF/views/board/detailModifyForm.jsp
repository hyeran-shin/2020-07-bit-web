<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
	function check(){
		var title = document.getElementById('title').value;
		if(title == "" || title == null ){
			alert("제목을 입력해주세요.");
			return false;
		}
	}
	
	function fileDelete(index, fileSaveName){
		var fileDelete = document.getElementById('file_list'+index);
		$(fileDelete).hide();
		
		var count = 0;
		var text = '<input type="hidden" name="deleteFileName" value="'+fileSaveName +'"/>';
		$('#hiddenContent').append(text);
		
	}
	
	
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
	</div>
	<div id="content" align="center">
		<hr width="80%">
		<h2>게시물 수정</h2>
		<hr width="80%">
	<form method="post" name="form" onsubmit="return check()" enctype="multipart/form-data">
		<table style="width:80%"  border="1">
			<tr>
				<th width="15%">글 번호</th>
				<td width="15%">${board.no }</td>
				<th width="15%">작성일</th>
				<td width="15%">${board.reg_date }</td>
			</tr>
			<tr>
				<th width="15%">작성자</th>
				<td width="15%">${board.writer }</td>
				<th width="15%">조회수</th>
				<td width="15%">${board.view_cnt }</td>
			</tr>
			<tr>
				<th width="15%">제목</th>
				<td colspan="3">
					<input type="text" style="width: 99%;  border-style: none;" id = "title" name="title" value=" ${board.title }">
				</td>
			</tr>
		 	<tr>
               <th width="15%">내용</th>
               <td colspan="3" width="15%">
                  <textarea rows="8" cols="80" name="content"
                   style="width: 99%; border-style: none; 
                   resize: none">${board.content }</textarea>
               </td>
            </tr>
            <tr>
               <th rowspan="2">첨부파일</th> 
               <c:if test="${not empty fileList }">
	               <td colspan="3">
	               		<c:forEach var="file" items="${fileList }" varStatus="i">
	               			<div id="file_list${i.index}">
								<a target="_blank" 
									href="/jblog-spring-prob/upload/${file.fileSaveName }"
									download="${file.fileOriName }"> 
									${file.fileOriName} &nbsp; (${file.fileSize } byte) &nbsp;</a> 
									<a href="#" onclick="fileDelete('${i.index}','${file.fileSaveName}')">삭제</a>
								<br>
							</div>
						</c:forEach>
					</td>
				</c:if>
            </tr>
            <tr>
	            <td colspan="3"> 
	               <input type="file" name="attachFile2" size="40"/>
	            </td>
            </tr>
		</table>
		<br>
	
		<c:if test="${board.writer eq user.id }">
			<input type="hidden" name="no" value="${board.no}">			
			<input type="hidden" name="list_idx"  value="${list_idx}">
			<input type="submit" value="수정 완료" style="padding: 10px; width : 10%;"
				onclick="javascript:form.action='/jblog-spring-prob/boardModify.do';">
			&nbsp;
			<input type="button" value="취소" style="padding: 10px; width : 10%;"
				onclick="history.back(-1);">
			<br>
		</c:if>
		<div id="hiddenContent"></div>
	</form>	
		<hr width="80%">

	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>