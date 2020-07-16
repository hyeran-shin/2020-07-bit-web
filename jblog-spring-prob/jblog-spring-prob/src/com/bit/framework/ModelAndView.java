package com.bit.framework;

import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
	private Map<String,Object> model;
	private String view;
	
	public ModelAndView() {
		model = new HashMap<>();
	}
	public Map<String, Object> getModel() {
		return model;
	}
	public void setModel(Map<String, Object> model) {
		this.model = model;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	
	public void addAttribute(String str, Object obj){
		model.put(str, obj);
	}
	
	
}
