package com.study.inflearn.web.frontcontroller.v2.controller;

import java.io.IOException;

import com.study.inflearn.web.frontcontroller.v2.ControllerV2;
import com.study.inflearn.web.frontcontroller.v2.ViewRenderer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV2 implements ControllerV2 {

	@Override
	public ViewRenderer process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return new ViewRenderer("/WEB-INF/views/new-form.jsp");
	}

}
