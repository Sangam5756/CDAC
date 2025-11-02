package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;

public class ShowUpcomingPatientAppointments {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in); 
				SessionFactory sf = getFactory()) {
			AppointmentDao appointmentDao=new AppointmentDaoImpl();
			System.out.println("Enter Patient id");
			appointmentDao.listUpcomingAppointmentsForPatient(sc.nextLong())
			.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
