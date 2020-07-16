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
   // 문서가 준비된 후 수행하라. (jQuery)
   //   -> $(document).ready(...)
  $(function(){
	  $('#btn-chkemail').click(function(){
		  // form:input path="email"의 Value 추출,  path는 id 값을 대신함. 
		 var email = $('#email').val();
	  	 if(email == '' ) return ; // 비어있다면 종료
	  	 
	  	 //jQuery ajax를 활용한 이메일 중복 체크
	  	 $.ajax({
	  		 // GET 방식으로 email 파라미터를 포함하여 /user/api/checkemail 요청을 보낼ㄱㅓ다.
	  		 url : '${pageContext.request.contextPath}/user/api/checkemail?email='+email,
	  		 type : 'get',
	  		 dataType : 'json',
	  		 data : '',
	  		 success : function(response){ // 요청 성공 시 받아온 응답 객체를 전달받는 익명함수 수행
	  			 
	  			 if(response.result == 'fail' ){ // 응답 결과가 fail 이라면,
	  				console.log(response.message);  // 콘솔 로그 출력후
	  				return; //종료
	  			 }
	  		 
	  		 	//success
	  		 	if(response.data == 'exist'){ // 이미 존재한다면,
	  		 		alert('이미 존재합니다. 다른 이메일을 사용해주세요.'); // 유저에게 알린 후
	  		 		$('#email').val('').focus(); // 입력란을 비운 뒤 포커스
	  		 		return; //종료
	  		 	}
	  		 	
	  		 	// 중복되지 않는다면
	  		 	$('#img-chkemail').show(); // 체크 이미지를 보여주고
	  		 	$('#btn-chkemail').hide(); // 중복 체크 버튼을 숨겨라
	  		 	// 단, 한번 체크 후 다시 체크할 수 없으니
	  		 	// 인터페이스 리펙토링 및 유효성 확인! (보다 좋은 방법임)
	  		 	
	  		 },
	  		 error : function(jqXHR, status, e){ // 별로 추천 암함?
	  			 console.log(jqXHR.status, status);
	  		 	// jqXHR (JQuery XML http Request)
	  		 	// ajax 요청에 error 발생 시 콘솔 로그에 상태와 내용을 출력
	  		 } 
	  		 
	  		 
	  	 });
	  	 
	  });
	  
	  
	  
      $('#join-form').submit(function(){ // submit 동작 시, 익명함수 호출
         // 조건에 따라 submit 동작을 중단하고 유저에게 알림.
         
         // "중복체크가 완료된 후, 나타나는 이미지"가 보여지는 상태가 아니라면
         if($('#img-chkemail').is(':visible') == false){
            alert('이메일 중복 체크를 하셔야 합니다.'); // 유저에게 알린 후
            return false; // submit 중단
         } 
         
         // "약관동의"의 체크박스가 체크 상태가 아니라면
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
            <!-- form:form : 데이터 바인딩 및 에러 처리 관련 스프링 프레임워크 태그 제공 -->
            <form:form modelAttribute="userVo" id="join-form" name="joinform" method="post" action="${pageContext.request.contextPath}/user/join">
               <label class="block-label" for="name">이름</label>
               <form:input path="name"/>
               <p style="text-align:left; color:red">
                  <form:errors path="name"/>
               </p>
               
               <label class="block-label" for="email">이메일</label>
               <form:input path="email"/>
               <!-- 사용가능한 이메일이라면 이미지 보여주기 -->
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
      <!-- 
      	navigation의 메뉴가 아닌 header의 메뉴에서 접근하는 페이지
      	navigation의 선택된 메뉴를 식별하기 위한 파라미터를 전달하지 않겠다.
       -->
      <c:import url="/WEB-INF/views/includes/navigation.jsp" />
      <c:import url="/WEB-INF/views/includes/footer.jsp" />
      
   </div>
   
</body>
</html>