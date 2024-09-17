package com.study.inflearn.response;

import java.io.IOException;
import java.io.PrintWriter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.inflearn.domain.InflearnData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseJSONServlet", urlPatterns = "/response-json")
public class ResponseJSONServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3041165637196899873L;

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Content-Type : application/json
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		InflearnData inflearnData = new InflearnData();
		inflearnData.setUsername("kim");
		inflearnData.setAge(20);

		String returnData = objectMapper.writeValueAsString(inflearnData);

		PrintWriter writer = response.getWriter();
		writer.write(returnData);
	}
}
