package com.study.inflearn.web.frontcontroller.v2;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.study.inflearn.web.frontcontroller.v2.controller.MemberFormControllerV2;
import com.study.inflearn.web.frontcontroller.v2.controller.MemberListControllerV2;
import com.study.inflearn.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

	private static final long serialVersionUID = 8170320753392494201L;

	private Map<String, ControllerV2> controllerMap = new HashMap<String, ControllerV2>();

	public FrontControllerServletV2() {
		controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
		controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
		controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String requestURI = request.getRequestURI();

		ControllerV2 controller = controllerMap.get(requestURI);

		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.out.println("404 NOT FOUND");
			return;
		}

		ViewRenderer viewRenderer = controller.process(request, response);
		viewRenderer.render(request, response);
	}
}
