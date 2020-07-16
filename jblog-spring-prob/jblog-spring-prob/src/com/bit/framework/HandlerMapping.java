package com.bit.framework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.bit.framework.annotation.RequestMapping;

public class HandlerMapping {
	private Map<String, CtrlAndMethod> mappings;
	
	public HandlerMapping(String ctrlsName) throws Exception {
		mappings = new HashMap<>();
		
		String[] controllers = ctrlsName.split("\\|");

		for (String controller : controllers) {
			controller = controller.trim();
			Class<?> clz = Class.forName(controller);
			Object target = clz.newInstance();
			Method[] methods = clz.getMethods();

			for (Method method : methods) {
				RequestMapping reqAnno = method.getAnnotation(RequestMapping.class);

				if (reqAnno == null) {
					continue;
				}

				String uri = reqAnno.value(); // @RequsetMapping("~~~")에서 ~~~
				CtrlAndMethod cam = new CtrlAndMethod(target, method);
				mappings.put(uri, cam);
			}

		}
	}
	
	public CtrlAndMethod getCtrlAndMethod(String uri) {
		return mappings.get(uri);
	}
}
