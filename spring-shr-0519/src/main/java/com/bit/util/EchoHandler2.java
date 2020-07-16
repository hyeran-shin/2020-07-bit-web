package com.bit.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler2 extends TextWebSocketHandler {
	// 전체 채팅 참여자
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	private static Logger logger = LoggerFactory.getLogger(EchoHandler2.class);

	// 클라이언트와 연결 된 후
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		sessionList.add(session);
		logger.info("{} 연결됨", session.getId());
		System.out.println("채팅방 입장자 : " + session.getPrincipal().getName());
	}

	// 웹 소켓 서버로 데이터를 전송했을 경우
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		logger.info(session.getId() + "님이 메시지 전송" + message.getPayload());
		System.out.println("getID : " + session.getId());
		System.out.println("payload : " + message.getPayload());

		// 모든 참여자에게 메시지 출력
		for (WebSocketSession sess : sessionList) {
			sess.sendMessage(new TextMessage(message.getPayload()));
		}
	}

	// 클라이언트 연결 끊었을떄
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		sessionList.remove(session);
		logger.info("{} 연결 끊김.", session.getId());
	}

}
