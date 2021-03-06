<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function memberDelete(){
		if(confirm('탈퇴 하시겠습니까?')){
			location.href = "/jblog-spring-prob/memberDelete.do?id="+'${member.id}';
		}
	}
</script>
</head>
<body>
	<div id="header">
		<jsp:include page="/WEB-INF/views/include/header.jsp" />
	</div>
	<div id="content" align="center">
		<hr width="80%">
		<h2>마이 페이지</h2>
		<hr width="80%">
		<br>		
		<form action="/jblog-spring-prob/myPageModifyForm.do" method="post">
			<table style= "width:50%" border="1">
				<tr>
					<th width="25%">아이디</th>
					<td>${member.id}</td>
				</tr>
				<tr>
					<th width="25%">이름</th>
					<td>${member.name}</td>
				</tr>
				<tr>
					<th width="25%">비밀번호</th>
					<td>${member.password}</td>
				</tr>
				<tr>
					<th width="25%">전화번호</th>
					<td>${member.tel1}- ${member.tel2} - ${member.tel3 }</td>
				</tr>
				<tr>
					<th width="25%">이메일</th>
					<td>${member.email_id}@${member.email_domain}</td>
				</tr>
				<tr>
					<th width="25%">우편번호</th>
					<td>(우)${member.post}</td>
				</tr>
				<tr>
					<th width="25%">주소</th>
					<td>${member.basic_addr}</td>
				</tr>
				<tr>
					<th width="25%">상세 주소</th>
					<td>${member.detail_addr}</td>
				</tr>
				<tr>
					<th width="25%">등급</th>
					<td>${member.type}</td>
				</tr>
				<tr>
					<th width="25%">가입 날짜</th>
					<td>${member.reg_date}</td>
				</tr>
			</table>
			
			<br>
			<input type="submit" value="정보 수정" />
			<input type="button" value="회원 탈퇴" onclick="memberDelete()" />
		</form>

	</div>
	<div id="footer">
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>

</body>

</html>