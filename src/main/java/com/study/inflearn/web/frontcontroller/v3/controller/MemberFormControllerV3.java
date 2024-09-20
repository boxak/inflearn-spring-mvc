package com.study.inflearn.web.frontcontroller.v3.controller;

import java.util.Map;

import com.study.inflearn.web.frontcontroller.v3.ControllerV3;
import com.study.inflearn.web.frontcontroller.v3.ModelView;

public class MemberFormControllerV3 implements ControllerV3 {

	@Override
	public ModelView process(Map<String, String> paramMap) {
		return new ModelView("new-form");
	}

}
