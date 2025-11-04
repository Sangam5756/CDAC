package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ems.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/emps")
public class EmployeeController {
	// depcy
	@Autowired
	private EmployeeService employeeService;

	/*
	 * Add req handling method - to render list of emps from dept URL -
	 * http://host:port/ctx_path/emps/list ,method=POST payload - departmentId =....
	 */
	@RequestMapping("/list")
	public String listEmpsByDepartment(Model modelAttrMap, @RequestParam(required = false) Long departmentId)

	// @RequestParam - Method argument Annotation to bind the incoming request
	// handling method argument
	// Long departmentId = Long.parseLong(request.getParameter("departmentId"))
	{
		System.out.println("in list emps " + modelAttrMap + " " + departmentId);// {}
		modelAttrMap.addAttribute("emp_list", employeeService.getEmpsByDeptId(departmentId));

		return "emps/list";// AVN - /WEB-INF/views/emps/list.jsp
		/*
		 * handler rets explicitly -> logical view name -> dispatcher servlet sc send
		 * implicitly -> model map DS -> LVN -> V.R -> AVN -> DS D.S checks for model
		 * attribute -> present -> adds it under request scope forwards the client to
		 * view layer
		 */
	}

	@GetMapping("/delete")
	public String deleteEmployeeDetails(Model modelMap, @RequestParam Long id, HttpSession session) {
		System.out.println("in del emp dts" + modelMap + " id is " + id);
		session.setAttribute("msg", employeeService.deleteEmployeeById(id));
		return "redirect:/emps/list"; // add the redirect

	}



}
