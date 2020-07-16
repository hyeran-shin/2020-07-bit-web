package com.bit.util;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandlerInterceptor2 extends HttpSessionHandshakeInterceptor {

//	@Autowired 
//	private UserDetailsService userService;
//	
	@Override
	public boolean beforeHandshake(
			ServerHttpRequest request, 
			ServerHttpResponse response,
			WebSocketHandler wsHandler, 
			Map<String, Object> attributes) throws Exception {
//		
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////		attributes.put(UserConfig.HEADER_USER_KEY, userService.findBy(user.getId()));
//
		System.out.println("handlerInterceptor!!!!!");
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}
}
