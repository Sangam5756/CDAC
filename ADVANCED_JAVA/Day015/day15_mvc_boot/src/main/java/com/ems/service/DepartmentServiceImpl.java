package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.DepartmentDao;
import com.ems.dao.EmployeeDao;
import com.ems.entities.Department;
import com.ems.entities.Employee;

@Service // mandatory class level annotation to declare a spring bean containing B.L
@Transactional // mandatory annotation fot auto tx management
public class DepartmentServiceImpl implements DepartmentService {
	// dependency - dao layer i/f
	@Autowired // by type
	private DepartmentDao departmentDao;
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Department> getAllDepartments() {
		// invoke dao's method
		return departmentDao.findAll();
	}

	@Override
	public String addEmployee(Employee e) {
		employeeDao.save(e);
		return "employee Added successfully";
	}

}
