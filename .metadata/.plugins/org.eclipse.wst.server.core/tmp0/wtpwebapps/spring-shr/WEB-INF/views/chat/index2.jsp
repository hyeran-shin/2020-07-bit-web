<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript"	src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<%@ page session="true"%>

<body>
	<h4 style="float: left;">채팅</h4>
	<img class="chat" src="${pageContext.request.contextPath}/assets/images/chat.png"
    	style="width: 50px; height: 50px;" />
   
	<div id="_chatbox" style="display: none;">
        <fieldset >
            <div id="messageWindow"></div>
            <br> 
       		<input type="text" id="sender" 
       			value="${sessionScope.member.m_id }" style="display: none;">
            
            <input id="inputMessage" type="text" onkeyup="enterkey()" value=""/>
            <input type="submit" value="send" onclick="send()" />
        </fieldset>
    </div>

</body>
<script type="text/javascript">
	$('.chat').on('click', function(){
		var c = document.getElementById('_chatbox');
		if(c.style.display=='none'){
			c.style.display='block';
			openSocket();
		}else{
			c.style.display='none';
			$('#messageWindow').empty();
			closeSocket();
		}
	});
	
	var ws;
	var messages = document.getElementById('messageWindow');
	
	function openSocket(){
		if(ws!=undefined && ws.readyState!==WebSocket.CLOSED){
			alert('Websocket is already opened.');
			return;
		}
		
		ws = new WebSocket('ws://localhost:8080/spring-shr/echo.do');
		
		ws.onopen = function(event){
			if(event.data == undefined) return;
			writeResponse(event.data);
		}
		ws.onmessage = function(event){
			writeResponse(event.data);
		}
		ws.onclose = function(event){
			alert('대화 종료');
		}

	}
	function send() {
		var text = document.getElementById('inputMessage').value;
		/* 	+ ','+ document.getElementById('sender').value; */
		ws.send(text);
		$('#inputMessage').val('');
	}

	function closeSocket() {
		ws.close();
	}

	function writeResponse(text) {
		messages.innerHTML += "<br>" + text;
	}

	function enterkey() {
		if (window.event.keyCode == 13) {
			send();
		}
	}

	window.setInterval(function() {
		var elem = document.getElementById('messageWindow');
		elem.scrollTop = elem.scrollHeight;
	}, 0);
</script>
</html>


