package com.study.inflearn.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.study.inflearn.member.domain.Member;
import com.study.inflearn.member.domain.MemberRepository;
import com.study.inflearn.web.frontcontroller.v2.ControllerV2;
import com.study.inflearn.web.frontcontroller.v2.ViewRenderer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberSaveControllerV2 implements ControllerV2 {

	private MemberRepository memberRepository = MemberRepository.getInstance();

	@Override
	public ViewRenderer process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		int age = Integer.parseInt(request.getParameter("age"));

		Member member = new Member(username, age);
		memberRepository.save(member);

		// Model에 데이터 보관
		request.setAttribute("member", member);

		return new ViewRenderer("/WEB-INF/views/save-result.jsp");
	}

}
