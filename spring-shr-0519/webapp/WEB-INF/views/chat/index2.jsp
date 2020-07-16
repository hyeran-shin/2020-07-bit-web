<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script type="text/javascript">
	alert("hi");
	var sock = null;
	$(document).ready(function(){
		sock = new SockJS("/spring-shr/echo");
		console.log(sock);
		
		sock.onopen = function(){
			sock.send('반갑습니다.');
		}
		sock.onmessage = function(evt){
			alert(evt.data);
			$('#chatMessage').append(evt.data + '<br>');
		}
		sock.onclose = function(){
			sock.send('퇴장');
		}
		
		$('#sendMessage').click(function(){
			sock.send('반갑습니다.')
			$('#chatMessage').append('반갑습니다.~');
		})
	});
	 
	
	/* 
	$('#sendBtn').click(function() {
		console.log('hihihihi');
		alert('click');
		sendMessage();
		$('#message').val('');
	});

	sock = new SockJS("/spring-shr/echo");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	// 메시지 전송
	function sendMessage() {
		sock.send($("#message").val());
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		var data = msg.data;
		$("#messageArea").append(data + "<br/>");
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");

	} */
</script>
</head>
<body>
	<h4> Chatting Page </h4>
	<input type="text" id="message" />
	<input type="button" id="sendMessage" value="메시지 보내기" />
	<div id="chatMessage" ></div>
	<hr>
	
	<h4> chatting test1 </h4>
	<input type="text" id="message2" />
	<input type="button" id="sendBtn" value="submit"/>
	<div id="messageArea"></div>
	
</body>


</html>