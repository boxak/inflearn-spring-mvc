package com.study.inflearn.web.frontcontroller.v1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.study.inflearn.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.study.inflearn.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.study.inflearn.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

	private static final long serialVersionUID = 8170320753392494201L;

	private Map<String, ControllerV1> controllerMap = new HashMap<String, ControllerV1>();

	public FrontControllerServletV1() {
		controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
		controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
		controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("FrontControllerServletV1.service");

		String requestURI = request.getRequestURI();

		ControllerV1 controller = controllerMap.get(requestURI);

		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			System.out.println("404 NOT FOUND");
			return;
		}

		controller.process(request, response);
	}
}
