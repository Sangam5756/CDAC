package com.ems.controller;
import com.ems.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ems.entities.Employee;
import com.ems.entities.EmploymentType;
import com.ems.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    private final EmployeeServiceImpl employeeServiceImpl;
	// depcy - service layer i/f
	@Autowired // by type
	private DepartmentService departmentService;

	public DepartmentController(EmployeeServiceImpl employeeServiceImpl) {
		System.out.println("in ctor of " + getClass());
		this.employeeServiceImpl = employeeServiceImpl;
	}

	// http://host:port/ctx_path/department/list , method=GET
	@GetMapping("/list")
	public ModelAndView listAllDepartments() {
		System.out.println("in list all depts");
		return new ModelAndView("dept/list", "department_list", departmentService.getAllDepartments());
		// AVN - /WEB-INF/views/dept/list.jsp
	}

	@GetMapping("/add_form")
	public String addEmployeeDetails(Model modelMap) {
		modelMap.addAttribute("new_emp", new Employee());
		modelMap.addAttribute("empTypes", EmploymentType.values());
		return "emps/add_emp_form";
	}

	@PostMapping("/add_form")
	public String processAddEmployeeForm(@ModelAttribute("new_emp") Employee emp) {
		System.out.println("Object is" + emp);
		departmentService.addEmployee(emp);

		return "redirect:/emps/list";
	}

}
