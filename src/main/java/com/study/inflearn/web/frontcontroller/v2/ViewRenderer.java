package com.study.inflearn.web.frontcontroller.v2;

import java.io.IOException;
import java.util.Map;
import java.util.function.BiConsumer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ViewRenderer {
	private String viewPath;

	public ViewRenderer(String viewPath) {
		this.viewPath = viewPath;
	}

	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		modelToRequestAttribute(model, request);

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);

	}

	private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
		model.forEach(new BiConsumer<String, Object>() {

			@Override
			public void accept(String key, Object value) {

				request.setAttribute(key, value);
			}

		});
	}
}
