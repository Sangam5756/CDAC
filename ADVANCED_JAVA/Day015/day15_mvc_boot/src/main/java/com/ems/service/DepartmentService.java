package com.ems.service;

import java.util.List;

import com.ems.entities.Department;
import com.ems.entities.Employee;

public interface DepartmentService {
	List<Department> getAllDepartments();
	String addEmployee(Employee e);
	
}
