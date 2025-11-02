package com.ems.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ems.entities.Department;

//this is mandatory class level annotation to declare dao layer repo spring bean singleton and eager repository
@Repository
public class DepartmentDaoImpl implements DepartmentDao {

//	dependancy is of dao layer is sessionFactory
	@Autowired // it will match by type
	private SessionFactory sessionFactory;

	@Override
	public List<Department> listAllDepartment() {

		String jpql = "FROM Department";

		return sessionFactory.getCurrentSession().createQuery(jpql, Department.class).getResultList();
	}

}
