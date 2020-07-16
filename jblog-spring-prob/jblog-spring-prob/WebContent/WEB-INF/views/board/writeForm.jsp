<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function moveToList() {
		location.href = "/jblog-spring-prob/boardList.do";
	}
	function check() {
		
		if (document.getElementById('title').value == "") {
			alert("제목 입력해주세요.");
			document.getElementById('title').focus();
			return false;
		}
		if ('${user.id}' == "") {
			alert("로그인 후 사용가능합니다.");
			location.href = "/jblog-spring-prob/loginForm.do";
			return false;
		}
	
	}
</script>
</head>
<body>
   <div id="header">
      <jsp:include page="/WEB-INF/views/include/header.jsp"/>
   </div>
   <div id="content" align="center">
      <hr width="80%"/>
      <h2>글 등록</h2>
      <hr width="80%"/>
      <form action="/jblog-spring-prob/boardWrite.do" method="post" enctype="multipart/form-data"
       	 	onsubmit="return check()">
         <input type="hidden" name="writer" value="${ user.id }"/>
         <table style= "width:80%" border="1">
            <tr>
               <th width="25%">제목</th>
               <td><input type="text" size="80" name="title" id="title"></td>
            </tr>
            <tr>
               <th width="25%">작성자</th>
               <td id="writer">${ user.id }</td>
            </tr>
            <tr>
               <th width="25%">내용</th>
               <td>
                  <textarea rows="8" cols="80" name="content"></textarea>
               </td>
            </tr>
            <tr>
               <th rowspan="2">첨부파일</th> 
               <td><input type="file" name="attachFile1" size="40"/></td>
            </tr>
            <tr>
	            <td>
	               <input type="file" name="attachFile2" size="40"/>
	            </td>
            </tr>
         </table>
         <br>
         <input type="submit" value="등록"/>&nbsp; &nbsp;
         <input type="button" value="목록" onclick="moveToList()"/>
      </form>
   </div>
   <div id="footer">
      <jsp:include page="/WEB-INF/views/include/footer.jsp"/>
   </div>
</body>
</html>