package com.ems.controller;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory class level annotation , to declare req handling (P.L) spring bean
public class HelloController {
	public HelloController() {
		System.out.println("in ctor of "+getClass());
	}
	/*
	 * Request http://host:port/ctx_path/
	 * Method - GET
	 */
	@RequestMapping("/") //or @GetMapping("/")
	public ModelAndView testModelAndView() {
		System.out.println("in test model n view");
		/*
		 * ModelAndView(String viewName, String attrName,Object value)
		 */
		return new ModelAndView("index", "server_time", LocalTime.now());
		//AVN - /WEB-INF/views/index.jsp
	}
}
