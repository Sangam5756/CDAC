package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;

public class BookAppointment {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);   SessionFactory sf = getFactory()) {
			AppointmentDao appointmentDao=new AppointmentDaoImpl();
			System.out.println("Enter doctor id , patient id , appointment TS(2025-12-03T10:15:30)");
			String message = appointmentDao.bookAppointment(sc.nextLong(),sc.nextLong(),LocalDateTime.parse(sc.next()));
			System.out.println(message);			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
