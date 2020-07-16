<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		
		<div id="content">
			<div id="user">
				<form id="join-form" name="joinform" method="post" action="">
					 <label class="block-label" for="name">이름</label>
					 <input type="text" id="name" name="name" value="${userVo.name}">
					  <spring:hasBindErrors name="userVo">
		                  <c:if test="${errors.hasFieldErrors('name')}">
		                     <p style="text-align:left; color:red">
		                        <spring:message code="${errors.getFieldError('name').codes[0]}" text="${errors.getFieldError('name').defaultMessage}"/>
		                     </p>
		                  </c:if>
               		 </spring:hasBindErrors>
               		 
               		 
					 <label class="block-label" for="email">이메일</label>
					 <input type="hidden" value="${userVo.no}" name="no">
					 <input type="hidden" value="${userVo.email}" name="email">
					 <strong>${userVo.email}</strong>
					 
					 <label class="block-label" for="password">패스워드</label>
					 <input type="password" name="password" value="">
					 <spring:hasBindErrors name="userVo">
		                  <c:if test="${errors.hasFieldErrors('password')}">
		                     <p style="text-align:left; color:red">
		                        <spring:message code="${errors.getFieldError('password').codes[0]}" text="${errors.getFieldError('password').defaultMessage}"/>
		                     </p>
		                  </c:if>
               		 </spring:hasBindErrors>
					 
					 <fieldset>
	    	             <legend>성별</legend>
	        	         <c:choose>
	            	     	<c:when test="${userVo.gender == 'male' }">
			        	         <label>남</label>
			        	         <input type="radio" name="gender" value="male" checked="checked">
			                	 <label>여</label>
			                 	 <input type="radio" name="gender" value="female">
	                 		</c:when>
	                 	
		                 	<c:otherwise>
		                 		 <label>남</label>
				            	 <input type="radio" name="gender" value="male">
				                 <label>여</label>
				                 <input type="radio" name="gender" value="female" checked="checked">
		                 	</c:otherwise>
						</c:choose>
		             </fieldset>
		             
		             <input type="submit" id="modify" value ="수정하기" formaction="${pageContext.request.contextPath }/user/modify">
		             <input type="submit" id="delete" value ="탈퇴하기" formaction="${pageContext.request.contextPath }/user/delete">
		        </form>
			</div>
		</div>
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>