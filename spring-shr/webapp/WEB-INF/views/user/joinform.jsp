<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
<script src="http://code.jquery.com/jquery-1.12.4.js"></script>
<script>
$(function(){
	  $('#btn-chkemail').click(function(){
		 var email = $('#email').val();
	  	 if(email == '' ) return ; 
	  	 
	  	 $.ajax({
	  		 url : '${pageContext.request.contextPath}/user/api/checkemail?email='+email,
	  		 type : 'get',
	  		 dataType : 'json',
	  		 data : '',
	  		 success : function(response){ 
	  			 
	  			 if(response.result == 'fail' ){ 
	  				console.log(response.message);  
	  				return; 
	  			 }
	  		 
	  		 	
	  		 	if(response.data == 'exist'){ 
	  		 		alert('이미 존재합니다. 다른 이메일을 사용해주세요.');
	  		 		$('#email').val('').focus(); 
	  		 		return;
	  		 	}
	  		 	
	  		 	$('#img-chkemail').show(); 
	  		 	$('#btn-chkemail').hide(); 
	  		 },
	  		 error : function(jqXHR, status, e){ 
	  			 console.log(jqXHR.status, status);
	  		 } 	  		 
	  	 });
	  	 
	  });
	  
	  
	  
    $('#join-form').submit(function(){ 
       if($('#img-chkemail').is(':visible') == false){
          alert('이메일 중복 체크를 하셔야 합니다.'); 
          return false;
       } 
       if($("#agree-prov").is(':checked') == false){
          alert('약관에 동의하셔야 합니다.');
          return false;
       } 
    });
 });
 
</script>
</head>
<body>
   <div id="container">
   	<c:import url="/WEB-INF/views/includes/header.jsp" />
      <div id="content">
         <div id="user">
            <form:form modelAttribute="userVo" id="join-form" name="joinform" method="post" action="${pageContext.request.contextPath}/user/join">
               <label class="block-label" for="name">이름</label>
               <form:input path="usersName"/>
               <p style="text-align:left; color:red">
                  <form:errors path="usersName"/>
               </p>
               
               <label class="block-label" for="email">이메일</label>
               <form:input path="email"/>
               <img id="img-chkemail" align="top" style="width:16px; display:none" src="${pageContext.request.contextPath}/assets/images/check.png">
               <input id="btn-chkemail" type="button" value="중복체크">
               <p style="text-align:left; color:red">
                  <form:errors path="email"/>
               </p>
               
               <label class="block-label">패스워드</label>
               <form:password path="password"/>
               <spring:hasBindErrors name="userVo">
                  <c:if test="${errors.hasFieldErrors('password')}">
                     <p style="text-align:left; color:red">
                        <spring:message code="${errors.getFieldError('password').codes[0]}" text="${errors.getFieldError('password').defaultMessage}"/>
                     </p>
                  </c:if>
               </spring:hasBindErrors>
               
               <fieldset>
                  <legend>성별</legend>
                  <label>남</label>
                  <input type="radio" name="gender" value="male" checked="checked">
                  <label>여</label>
                  <input type="radio" name="gender" value="female">
               </fieldset>
               
               <fieldset>
                  <legend>약관동의</legend>
                  <input id="agree-prov" type="checkbox" name="agreeProv" value="y">
                  <label>서비스 약관에 동의합니다.</label>
               </fieldset>
               
               <input type="submit" value="가입하기">
            </form:form>
         </div>
      </div>
   
      <c:import url="/WEB-INF/views/includes/navigation.jsp" />
      <c:import url="/WEB-INF/views/includes/footer.jsp" />
      
   </div>
   
</body>
</html>