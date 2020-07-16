package com.bit.log1.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LogController01 {
	/**
	 * Logger 생성(Console)
	 */
	private static final Log LOG = LogFactory.getLog(LogController01.class);
	
	@RequestMapping("/ex01")
	@ResponseBody
	public String ex01() {
		/**
		 *  [로그 순서]
		 *  debug > info > warn >error 순으로 로그 출력되게 만들거다
		 *  
		 *  logback.xml 에서 
		 *  root logger의 level="info"라면, 
		 *  info, warn, error 로그 출력된다.
		 */
		
		LOG.debug("#ex01 - debug log"); 	// debug level 등록
		LOG.info("#ex01 - info log");		// info  level 등록
		LOG.warn("#ex01 - warn log");		// warn  level 등록
		LOG.error("#ex01 - error log");		// error level 등록
		// 특정 로직에 대해, 예외 처리 또는 수행 시간에 따라 로그 기록
		//	-> 자바에서 보았던 try{} catch{} finally{} 구문의
		//	   catch() {} 영역에 활용 권장
		
		return "Logback Logging Ex01 Response..."; 
		// Message Converter를 등록하지 않으니, 영어로 작성!
		// Message Converter -> 한글 출력하기 위해 인코딩작업해주는것
	}
}









 