package com.healthcare.appointmenttest;

import java.util.Scanner;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;

public class BookAppointment {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			AppointmentDao appointment = new AppointmentDaoImpl();

			System.out.println("Enter the Data DoctorId PatientId appointmentDate");
 
			System.out.println(appointment.BookAppointMent(sc.nextInt(), sc.nextInt(), sc.next()));

			appointment.cleanup();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
