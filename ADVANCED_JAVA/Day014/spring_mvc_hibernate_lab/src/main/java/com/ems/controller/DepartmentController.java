package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ems.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	public DepartmentController() {
		System.out.println("Inside the departmentController");
	}

	@GetMapping("/list")
	public ModelAndView listAllDepartment() {

		return new ModelAndView("dept/list", "department", departmentService.getAllDepartments());
	}

}
