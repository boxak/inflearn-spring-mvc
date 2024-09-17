package com.study.inflearn.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "inflearnServlet", urlPatterns = "/inflearn")
public class InflearnServlet extends HttpServlet {

	private static final long serialVersionUID = -4312449974286447369L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//		super.service(req, resp);
		System.out.println("InflearnServlet.service");
		System.out.println("request = " + request);
		System.out.println("response = " + response);

		String username = request.getParameter("username");
		System.out.println("username = " + username);

		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("hello " + username);
	}

}
