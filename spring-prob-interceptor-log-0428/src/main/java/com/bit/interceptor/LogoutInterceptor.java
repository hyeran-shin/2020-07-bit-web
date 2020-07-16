package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogoutInterceptor extends HandlerInterceptorAdapter {

	private static final Log LOG = LogFactory.getLog(LogoutInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj ) throws Exception{
		System.out.println("LogoutInterceptor.preHandler() Method Called...");
		LOG.debug("#LogoutInterceptor.preHandle() - debug log");
		LOG.info("#LogoutInterceptor.preHandle() - info log");
		LOG.warn("#LogoutInterceptor.preHandle() - warn log");
		LOG.error("#LogoutInterceptor.preHandle() - error log");
		return true;
	}
	
}
