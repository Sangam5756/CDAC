package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public String bookAppointment(Long doctorId, Long patientId, LocalDateTime ts) {

		String mesg = "Appointment un available , Please choose another Date/Time";
		if (isDoctorAvailable(doctorId, ts)) {
			// 1. Get Session from SessionFactory
			Session session = getFactory().getCurrentSession();
			// 2. Begin Tx
			Transaction tx = session.beginTransaction();
			try {
				//3. get Doctor from its id  
				Doctor doctor=session.find(Doctor.class, doctorId);
				//4. get Patient ref from its id 
				Patient patient=session.find(Patient.class, patientId);
				if(doctor != null && patient != null)
				{
					//=> doc & patient exists -> set up associations
					Appointment newAppointment=new Appointment(ts, doctor, patient);//newAppointment : transient
					session.persist(newAppointment);//newAppointment : persitent
					mesg="appointment booked with id="+newAppointment.getId();
					
				} else {
					mesg="Invalid doctor or patient ids...";
				}
				
				tx.commit();//session.flush-> auto dirty chking -> DML -> session.close()
			} catch (RuntimeException e) {
				if (tx != null)
					tx.rollback();
				// re throw the exception to the caller
				throw e;
			}
		}
		return mesg;
	}

	@Override
	public String cancelAppointment(Long appointmentId, Long patientId) {

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
		return null;
	}

	private boolean isDoctorAvailable(Long docId, LocalDateTime dateTime) {
		List<Long>appointmentIds = null;
//		String jpql = """
//				select a.id from Appointment a where a.myDoctor.id=:did and a.appointmentDateTime=:ts and a.status=:sts
//				""";
		/*
		 * More practical testing
		 * Suppose appointment duration time - 30 mins
		 * Time 11:00 AM
		 * Then to avoid any overlap ,there shouldn't be any prior appointment
		 * from 10:30 -11:30
		 * If exists - then you can't book your appointment !
		 * 
		 */
		LocalDateTime startTime=dateTime.minusMinutes(30);
		LocalDateTime endTime=dateTime.plusMinutes(30);
		String jpql = """
				select a.id from Appointment a where a.myDoctor.id=:did and a.appointmentDateTime between :start and :end  and a.status=:sts
				""";
		
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			appointmentIds = session.createQuery(jpql, Long.class)
					.setParameter("did", docId)
					.setParameter("start", startTime)
					.setParameter("end", endTime)
					.setParameter("sts", Status.SCHEDULED)
					.getResultList();
					
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return appointmentIds.isEmpty();
	}

	@Override
	public List<AppointmentDTO> listUpcomingAppointmentsForPatient(Long patientId) {
		List<AppointmentDTO> list = null;
		String jpql = """
				select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment a where a.myPatient.id=:pid and a.status=:sts
				""";

		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			list = session.createQuery(jpql, AppointmentDTO.class).setParameter("pid", patientId)
					.setParameter("sts", Status.SCHEDULED).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return list;
	}

	@Override
	public List<AppointmentDTO> listUpcomingAppointmentsForDoctor(Long doctorId) {

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
		return null;

	}

}
