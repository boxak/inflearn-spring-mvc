package com.study.inflearn.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3735696266161154561L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// [status-line]
		response.setStatus(HttpServletResponse.SC_OK);

		// [response-header]
		//		response.setHeader("Content-Type", "text/plain;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");

		// [Header 편의 메서드]
		//		content(response);
		//		cookie(response);

		redirect(response);

		PrintWriter writer = response.getWriter();
		writer.println("ok");
	}

	private void redirect(HttpServletResponse response) throws IOException {

		// redirect 할 때 상태코드를 300번대로 지정해야 함
		//		response.setStatus(HttpServletResponse.SC_FOUND);
		//		response.setHeader("Location", "/basic/hello-form.html");
		response.sendRedirect("/basic/hello-form.html");
	}

	private void content(HttpServletResponse response) {
		//Content-Type: text/plain;charset=utf-8
		//Content-Length: 2
		//        response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.setContentLength(2); //(생략시 자동 생성)
	}

	private void cookie(HttpServletResponse response) {
		Cookie cookie = new Cookie("myCookie", "good");

		cookie.setMaxAge(600);

		response.addCookie(cookie);

	}
}
