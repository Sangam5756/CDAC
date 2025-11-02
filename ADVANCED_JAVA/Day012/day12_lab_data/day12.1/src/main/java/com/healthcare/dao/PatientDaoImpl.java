package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.Patient;

public class PatientDaoImpl implements PatientDao {

	@Override
	public String registerPatient(Patient patient) {
		String mesg="Registering patient failed....";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			//save use details - parent rec
		//	session.persist(patient.getUserDetails());//user : persistent - cascade
			session.persist(patient);//patient : persistent
			
			tx.commit();
			mesg="Patient registered with ID "+patient.getId();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}

		return mesg;
	}

	@Override
	public Patient getPatientDetails(Long userId) {
		Patient patient=null;
		String jpql="select p from Patient p  where p.userDetails.id=:uid";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			patient=session.createQuery(jpql, Patient.class)
					.setParameter("uid",userId)
					.getSingleResult();
					//simply access set of diagTests - from within the session scope
			patient.getDiagnosticTests().size();//hint 
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return patient;
	}
	
	

}
