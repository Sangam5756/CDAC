package com.ems.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
//derived query - finder - select e from Employee e where e.myDepartment.id=:deptId
	List<Employee> findByMyDepartmentId(Long deptId);

// using the inherited method delete by id
//	void deleteById(Long id);
}
