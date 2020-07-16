package com.bit.controller;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class HandlerMapping {
	
	private Map<String,IController> map = null;
	
	public HandlerMapping(String configName){ // 생성자 , configName : "bean.properties" 가 넘어옴
		
		map = new HashMap<>();
		Properties prop = new Properties();
		
		try {
			InputStream inputStream = this.getClass().getResourceAsStream(configName);
			prop.load(inputStream);
			
			Set<Object> keySet = prop.keySet();
			for(Object key : keySet) {
				String className = prop.getProperty(key.toString());
//				Class<?> cls = Class.forName(className);
				IController value = (IController) Class.forName(className).newInstance();
				map.put((String) key, value);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public IController getController(String uri) {
		return map.get(uri);
	}
	
}
