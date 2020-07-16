<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="navigation">
	<ul>
		<c:choose>
			<c:when test="${param.menu == 'main' }">
				<li class="selected"><a href="${pageContext.request.contextPath}"> Home </a></li>
				<li><a href="${pageContext.request.contextPath }/order"> 주문요청 </a></li>
				<li><a href="${pageContext.request.contextPath }/board"> 질문게시판 </a></li>
				<c:if test="${ not empty authUser and authUser.usersType == 'admin' }">
					<li><a href="${pageContext.request.contextPath }/product"> 상품등록 </a></li>
					<li><a href="${pageContext.request.contextPath }/order/status"> 주문현황 </a></li>
				</c:if>
			</c:when>
				
			<c:when test="${param.menu == 'board' }">
				<li><a href="${pageContext.request.contextPath}"> Home </a></li>
				<li><a href="${pageContext.request.contextPath }/order"> 주문요청 </a></li>
				<li class="selected"><a href="${pageContext.request.contextPath }/board"> 질문게시판 </a></li>
				<c:if test="${ not empty authUser and authUser.usersType == 'admin' }">
					<li><a href="${pageContext.request.contextPath }/product"> 상품등록 </a></li>
					<li><a href="${pageContext.request.contextPath }/order/status"> 주문현황 </a></li>
				</c:if>
			</c:when>	
			
			<c:when test="${param.menu == 'order' }">
				<li><a href="${pageContext.request.contextPath}"> Home </a></li>
				<li class="selected"><a href="${pageContext.request.contextPath }/order"> 주문요청 </a></li>
				<li><a href="${pageContext.request.contextPath }/board"> 질문게시판 </a></li>
				<c:if test="${ not empty authUser and authUser.usersType == 'admin' }">
					<li><a href="${pageContext.request.contextPath }/product"> 상품등록 </a></li>
					<li><a href="${pageContext.request.contextPath }/order/status"> 주문현황 </a></li>
				</c:if>
			</c:when>	
			
			<c:when test="${param.menu == 'product' }">
				<li><a href="${pageContext.request.contextPath}"> Home </a></li>
				<li><a href="${pageContext.request.contextPath }/order"> 주문요청 </a></li>
				<li><a href="${pageContext.request.contextPath }/board"> 질문게시판 </a></li>
				<c:if test="${ not empty authUser and authUser.usersType == 'admin' }">
					<li class="selected"><a href="${pageContext.request.contextPath }/product"> 상품등록 </a></li>
					<li><a href="${pageContext.request.contextPath }/order/status"> 주문현황 </a></li>
				</c:if>
			</c:when>	
			
			<c:when test="${param.menu == 'orderStatus' }">
				<li><a href="${pageContext.request.contextPath}"> Home </a></li>
				<li><a href="${pageContext.request.contextPath }/order"> 주문요청 </a></li>
				<li><a href="${pageContext.request.contextPath }/board"> 질문게시판 </a></li>
				<c:if test="${ not empty authUser and authUser.usersType == 'admin' }">
					<li><a href="${pageContext.request.contextPath }/product"> 상품등록 </a></li>
					<li class="selected"><a href="${pageContext.request.contextPath }/order/status"> 주문현황 </a></li>
				</c:if>
			</c:when>	
			
			<c:otherwise>
				<li><a href="${pageContext.request.contextPath}"> Home </a></li>
				<li><a href="${pageContext.request.contextPath }/order"> 주문요청 </a></li>
				<li><a href="${pageContext.request.contextPath }/board"> 질문게시판 </a></li>
				<c:if test="${ not empty authUser and authUser.usersType == 'admin' }">
					<li><a href="${pageContext.request.contextPath }/product"> 상품등록 </a></li>
					<li><a href="${pageContext.request.contextPath }/order/status"> 주문현황 </a></li>
				</c:if>
			</c:otherwise>
		</c:choose>
	</ul>
</div>    

 
 