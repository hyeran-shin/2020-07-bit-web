<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<script src="https://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>

<script type="text/javascript">
bit.webSocket = {
	      init: function (oParam) {
	          this._url = oParam.url || "";
	          this._initSocket();
	          this._initEvent();
	      },
	      _initSocket: function () {
	          this._socket = new SockJS(this._url); // 소켓 연결
	          this._socket.onmessage = function (evt) { // evt 파라미터는 웹소켓을 보내준 데이터
	              $("#data").append(evt.data + "<br/>");
	          };
	          this._socket.onclose = function (evt) {
	              $("#data").append("연결 끊김");
	          }
	      },
	      _initEvent: function () {
	          $("#sendBtn").on("click", (function() {
	              var msg = $("#message").val();
	              this._socket.send(msg);
	          }).bind(this));
	      }
	  };
	  
$(document).ready(function() { 
	bit.webSocket.init({ 
		url: "<c:url value="${pageContext.request.contextPath}/echo" />" 
		}); 
	});


</script>
</head>

<body>

	<input type="text" id="message" />
	<input type="button" id="sendBtn" value="전송" />
	<div id="data"></div>

</body>

</html>
