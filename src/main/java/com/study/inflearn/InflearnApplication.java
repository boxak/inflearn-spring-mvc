package com.study.inflearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class InflearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(InflearnApplication.class, args);
	}

}
