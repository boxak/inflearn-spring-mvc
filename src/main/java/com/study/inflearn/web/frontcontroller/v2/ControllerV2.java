package com.study.inflearn.web.frontcontroller.v2;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ControllerV2 {
	ViewRenderer process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
