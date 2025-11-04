package com.cdac.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/test")
public class TestController {
	public TestController() {
		System.out.println("in ctor of " + getClass());
	}

	// URL - http://host:port/test , method=GET
	// Resp - List of numbers -> Json[] -> clnt
	@GetMapping
	public List<Integer> testMe() {
		System.out.println("in test me");
		return List.of(10, 20, 30, 40, 50);
	}
	
	
}
