package com.ems.service;

import java.util.List;

import com.ems.entities.Employee;

public interface EmployeeService {
//get all emps from dept by id
	List<Employee> getEmpsByDeptId(Long deptId);

	String deleteEmployeeById(Long id);

}
