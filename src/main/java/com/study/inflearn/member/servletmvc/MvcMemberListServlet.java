package com.study.inflearn.member.servletmvc;

import java.io.IOException;
import java.util.List;

import com.study.inflearn.member.domain.Member;
import com.study.inflearn.member.domain.MemberRepository;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6036257534410165450L;
	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Member> members = memberRepository.findAll();

		// Model에 데이터 보관
		request.setAttribute("members", members);

		String viewPath = "/WEB-INF/views/members.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
