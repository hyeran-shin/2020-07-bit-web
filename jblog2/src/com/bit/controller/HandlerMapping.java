package com.bit.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	private Map<String, Controller> mappings = null;

	// configName : 설정 파일 경로
	public HandlerMapping(String configName) {
		mappings = new HashMap<>();

		Properties prop = new Properties();

		try {
			// Resources 상대 경로 입력
			InputStream inputStream 
				= this.getClass().getResourceAsStream(configName);
			
			prop.load(inputStream);
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
				
				Class<?> clz = Class.forName(className);
				
				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 요청 들어온 uri에 대한 Controller 객체를 반환
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
}
