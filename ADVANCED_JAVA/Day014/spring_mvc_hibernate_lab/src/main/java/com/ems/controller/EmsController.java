package com.ems.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmsController {

	public EmsController() {
		System.out.println("inside the EmsController" + getClass());
	}

	@GetMapping("/")
	public ModelAndView DateTime() {
//get mapping will not required any input just directly return the response

		return new ModelAndView("test", "server", LocalDateTime.now());
//			web-inf/views/date.jsp
	}

}
