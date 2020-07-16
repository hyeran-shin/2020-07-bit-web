package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletController extends HttpServlet {

	private static final long serialVersionUID = 3747260950213063851L;

	private HandlerMapping mapping = null;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String configName = config.getInitParameter("configName"); // 출력 값 : bean.peoperties
		mapping = new HandlerMapping(configName);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String uri = request.getRequestURI();
			String context = request.getContextPath();
			uri = uri.substring(context.length());

			IController Controller = mapping.getController(uri);
			String callPage = Controller.handlerRequest(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
