package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.Doctor;

public class DoctorDaoImpl implements DoctorDao {

	@Override
	public String registerDoctor(Doctor doctor) {
		String mesg="Registering Doctor failed....";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			//in the absence of cascading - explicitly save user details first
		//	session.persist(doctor.getUserDetails());
			//save doc details
			session.persist(doctor);
			
			tx.commit();
			mesg="Registered doctor with ID"+doctor.getId();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public Doctor getDoctorDetails(Long userId) {
		Doctor doctor=null;
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
			// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return doctor;
	}

}
