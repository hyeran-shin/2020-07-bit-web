package com.bit.mysite.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.RemoteEndpoint.Basic;

@Controller
@ServerEndpoint(value = "/echo.do") // url 요청을 통해 웹소켓에 들어가겠따.
public class WebSocketController {
	private static final List<Session> sessionList = new ArrayList<Session>();;
	private static final Logger logger = LoggerFactory.getLogger(WebSocketController.class);

	public WebSocketController() {
		System.out.println("웹소켓(서버) 객체생성");
	}

	@RequestMapping(value = "/chat.do")
	public ModelAndView getChatViewPage(ModelAndView mav) {
		mav.setViewName("chat/index");
		return mav;
	}
	@RequestMapping(value = "/chat2.do")
	public ModelAndView getChatViewPage2(ModelAndView mav) {
		mav.setViewName("chat/index2");
		return mav;
	}

	// 클라이언트가 웹소켓에 들어오고 서버에 아무런 문제 없이 들어왔을 때 실행하는 메소드
	@OnOpen
	public void onOpen(Session session) {
		logger.info("Open session id:" + session.getId());
		try {
			sessionList.add(session);
			final Basic basic = session.getBasicRemote();
			String msg = session.getId() +"님이 대화방을 입장하였습니다. 현재 사용자 :" + sessionList.size() +"명" ;
			basic.sendText(msg);
			sendAllSessionToMessage(session, msg , 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * 메시지 보낸 자신을 제외한 
	 * 모든 사용자에게 메시지를 전달한다.
	 */
	private void sendAllSessionToMessage(Session self, String message , int start) {
		try {
			for (Session session : WebSocketController.sessionList) {
//				session.getBasicRemote().sendText(message.split(",")[1] + " :12312 " + message);
				if (!self.getId().equals(session.getId())) {
					if(start==1) { //입장,퇴장 알림
						session.getBasicRemote().sendText(message);
					}else {
						session.getBasicRemote().sendText(self.getId()+"님 : " + message);
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		// 클라이언트에게 메시지가 들어왔을때
//		logger.info("Message From " + message.split(",")[1] + ": " + message.split(",")[0]);
		sendAllSessionToMessage(session, message,0);
		try {
			final Basic basic = session.getBasicRemote();
			basic.sendText(session.getId() +"님 : " + message);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

	@OnError
	public void onError(Throwable e, Session session) {
		e.printStackTrace();
	}

	@OnClose
	public void onClose(Session session) {
		logger.info("Session " + session.getId() + " has ended");
		sendAllSessionToMessage(session, session.getId() +"님이 대화방을 퇴장하였습니다.",1);
		sessionList.remove(session);
	}

}
