package com.bit.framework;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3719201454070450384L;

	private HandlerMapping mappings;

	@Override
	public void init(ServletConfig config) throws ServletException {
		String ctrlsName = config.getInitParameter("controllers");
		try {
			mappings = new HandlerMapping(ctrlsName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("DispatcherServlet Service Called...");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		uri = uri.substring(contextPath.length());

		CtrlAndMethod cam = mappings.getCtrlAndMethod(uri);
		String view = "";
		try {
			if (cam == null) {
				throw new Exception("요청하신 페이지가 존재하지 않습니다.");
			}
			Object target = cam.getTarget();
			Method method = cam.getMethod();
			// 구체적인 클래스 타입을 알지 못하면 메소드 실행 못함. Object로 실행 X
			// 코드 시작 시점 어떤 타입의 클래스를 사용할지 모를떄?
			ModelAndView mav = (ModelAndView) method.invoke(target, request, response);
			Map<String, Object> model = mav.getModel();
			Set<String> keys = model.keySet();

			System.out.println("model : " + model);
			System.out.println("keys : " + keys);

			for (String key : keys) {
				request.setAttribute(key, model.get(key));
			}
			view = mav.getView();

		} catch (Exception e) {
			request.setAttribute("exception", e);
			view = "/ErrorServlet";
		}

		if (view.startsWith("redirect:")) {
			view = view.substring("redirect:".length());
			response.sendRedirect(view);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request, response);
		}

	}
}
