package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.controller.EmployeeController;
import com.ems.dao.EmployeeDao;
import com.ems.entities.Employee;

@Service
@Transactional // implicityl close and open the transaction
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmpsByDeptId(Long deptId) {
		// TODO Auto-generated method stub
		return employeeDao.findByMyDepartmentId(deptId);
	}

	@Override
	public String deleteEmployeeById(Long id) {

		if (employeeDao.existsById(id)) {

			employeeDao.deleteById(id);
			return "deletion successfull";
		}
		return "deletion failed";

	}

}
