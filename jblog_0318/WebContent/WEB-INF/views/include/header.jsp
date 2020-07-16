<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1" width="100%">
	<tr>
		<td rowspan="2" style="width: 200px; height: 20px;" align="center">
			<a href="/jblog"> 
				<img src="/jblog/assets/images/logo.png" 
					style="border:1px; width:200px; height:40px"/>
			</a>
		</td>
	</tr>

	<tr align="center">
		<!-- 
			header 메뉴 구성
				로그인 전 : 자유 게시판 || 회원가입 || 로그인
				슈퍼 유저 : 회원 관리 || 자유 게시판 || 로그아웃
				일반 유저 : 자유 게시판 || 마이 페이지 || 로그아웃
		 -->
		 <th>
			 <a href="">자유 게시판</a> ||
			 <a href="">회원 가입</a> ||
			 <a href="/jblog/loginForm.do">로그인</a>
		 </th>
	</tr>

</table>