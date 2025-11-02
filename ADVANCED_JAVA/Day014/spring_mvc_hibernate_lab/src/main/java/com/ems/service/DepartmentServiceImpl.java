package com.ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.DepartmentDao;
import com.ems.entities.Department;

//it is mandatory class level  annotation for declarating the service layer bl logic
@Service
@Transactional // this added for auto tx management
public class DepartmentServiceImpl implements DepartmentService {

//	service is dependent on the dao
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public List<Department> getAllDepartments() {

		return departmentDao.listAllDepartment();
	}

}
