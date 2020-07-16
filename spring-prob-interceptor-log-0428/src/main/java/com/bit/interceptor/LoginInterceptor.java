package com.bit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	private static final Log LOG = LogFactory.getLog(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor.preHandle() Method Called...");
		LOG.debug("#LoginInterceptor.preHandle() - debug log");
		LOG.info("#LoginInterceptor.preHandle() - info log");
		LOG.warn("#LoginInterceptor.preHandle() - warn log");
		LOG.error("#LoginInterceptor.preHandle() - error log");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("LoginInterceptor.postHandle() Method Called...");		
		LOG.debug("#LoginInterceptor.postHandle() - debug log");
		LOG.info("#LoginInterceptor.postHandle() - info log");
		LOG.warn("#LoginInterceptor.postHandle() - warn log");
		LOG.error("#LoginInterceptor.postHandle() - error log");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("LoginInterceptor.afterCompletion() Method Called...");
		LOG.debug("#LoginInterceptor.afterCompletion() - debug log");
		LOG.info("#LoginInterceptor.afterCompletion() - info log");
		LOG.warn("#LoginInterceptor.afterCompletion() - warn log");
		LOG.error("#LoginInterceptor.afterCompletion() - error log");
	}

}
