package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.entities.BloodGroup;
import com.healthcare.entities.Gender;
import com.healthcare.entities.Patient;
import com.healthcare.entities.User;
import com.healthcare.entities.UserRole;

public class PatientRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in);
				SessionFactory sf = getFactory()) {

			PatientDao patientDao = new PatientDaoImpl();
			System.out.println(
					"Enter Basic Details -  firstName,  lastName,  email,  password,  phone,  dob , reg amount");
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					sc.nextInt());
			user.setRole(UserRole.ROLE_PATIENT);
			
			System.out
					.println("Add Patient specific details - gender, BloodGroup bloodGroup");
			Gender gender = Gender.valueOf(sc.next().toUpperCase());
			BloodGroup bloodGroup = BloodGroup.valueOf(sc.next().toUpperCase());
			sc.nextLine();
			System.out.println("Enter Family History");
			Patient patient = new Patient(gender,bloodGroup,sc.nextLine());
			//Establish one-one association (uni dir) - Patient -> User
			patient.setUserDetails(user);
			
			System.out.println(patientDao.registerPatient(patient));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
