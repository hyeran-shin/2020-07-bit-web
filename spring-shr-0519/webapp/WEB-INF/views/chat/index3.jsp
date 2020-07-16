<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/sockjs.js"></script>
<script type="text/javascript">
 
    $(document).ready(function(){
        $("#sendBtn").click(function(){
            sendMessage();
        });
    });
    
    var sock= new SockJS("<c:url value="/echo"/>");
    sock.onmessage = onMessage;
    sock.onclose = onClose;
    
    
    function sendMessage(){
    	sock.send($("#message").val());
    }
            
    //evt : websocket이 보내준 데이터
    function onMessage(evt){  
        var data = evt.data;
        $("#data").append(data+"<br/>");
        /* sock.close(); */
    }
    
    function onClose(evt){
        $("#data").append("연결 끊김");
    }
    
</script>
</head>
<body>
    <input type="text" id="message"/>
    <input type="button" id="sendBtn" value="전송"/>
    <div id="data"></div>
</body>
</html>


