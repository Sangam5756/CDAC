package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Status;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public String bookAppointment(Long doctorId, Long patientId, LocalDateTime ts) {
		String mesg = "Appointment un available , Please choose another Date/Time";
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

	private boolean isDoctorAvailable(Long docId, LocalDateTime ts) {
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
		return false;
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
			list=session.createQuery(jpql, AppointmentDTO.class)
					.setParameter("pid", patientId)
					.setParameter("sts",Status.SCHEDULED)
					.getResultList();
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
