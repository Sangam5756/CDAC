package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.User;
import com.healthcare.entities.UserRole;

public class DoctorRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {

			DoctorDao doctorDao = new DoctorDaoImpl();
			System.out.println(
					"Enter Basic Details -  firstName,  lastName,  email,  password,  phone,  dob , reg amount");
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					sc.nextInt());
			user.setRole(UserRole.ROLE_DOCTOR);
			// User registeredUser = userDao.registerUser(user);
			System.out
					.println("Add Doctor specific details -speciality,  experience in years,  qualifications,  fees ");
			Doctor doctor = new Doctor(sc.next(), sc.nextInt(), sc.next(), sc.nextInt());
			//Establish one-one association (doctor 1---->1 user)
			doctor.setUserDetails(user);
			System.out.println(doctorDao.registerDoctor(doctor));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
