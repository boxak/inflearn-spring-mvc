package com.study.inflearn.web.frontcontroller.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.study.inflearn.web.frontcontroller.v2.ViewRenderer;
import com.study.inflearn.web.frontcontroller.v3.controller.MemberFormControllerV3;
import com.study.inflearn.web.frontcontroller.v3.controller.MemberListControllerV3;
import com.study.inflearn.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4320707601506883700L;

	private Map<String, ControllerV3> controllerMap = new HashMap<String, ControllerV3>();

	public FrontControllerServletV3() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();

		ControllerV3 controller = controllerMap.get(requestURI);

		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.out.println("404 NOT FOUND");
			return;
		}

		Map<String, String> paramMap = createParamMap(request);

		ModelView modelView = controller.process(paramMap);
		String viewName = modelView.getViewName();

		ViewRenderer viewRenderer = viewResolver(viewName);
		viewRenderer.render(modelView.getModel(), request, response);
	}

	private ViewRenderer viewResolver(String viewName) {
		ViewRenderer viewRenderer = new ViewRenderer("/WEB-INF/views/" + viewName + ".jsp");
		return viewRenderer;
	}

	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<String, String>();
		request.getParameterNames().asIterator().forEachRemaining(new Consumer<String>() {

			@Override
			public void accept(String paramName) {
				paramMap.put(paramName, request.getParameter(paramName));

			}

		});
		return paramMap;
	}

}
