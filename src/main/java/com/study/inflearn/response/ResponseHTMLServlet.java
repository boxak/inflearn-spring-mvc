package com.study.inflearn.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHTMLServlet", urlPatterns = "/response-html")
public class ResponseHTMLServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3315911613143665309L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Content-Type : text/html;charset=UTF-8

		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter writer = response.getWriter();
		writer.println("<html>");
		writer.println("<body>");
		writer.println("    <div>안녕</div>");
		writer.println("</body>");
		writer.println("</html>");
	}
}
