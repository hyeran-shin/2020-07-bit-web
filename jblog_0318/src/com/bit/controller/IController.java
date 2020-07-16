package com.bit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IController {
	public String handlerRequest(HttpServletRequest request ,
								HttpServletResponse response)
								throws Exception; // 각 view의 해당 controller return 해야 함.
}
