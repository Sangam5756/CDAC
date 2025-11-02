package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.dao.UserDao;
import com.healthcare.dao.UserDaoImpl;
import com.healthcare.entities.Patient;
import com.healthcare.entities.User;
import com.healthcare.entities.UserRole;

public class CommonUserLogin {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {

			UserDao userDao = new UserDaoImpl();
			System.out.println("Enter email & password");
			User user = userDao.signIn(sc.next(), sc.next());
			/* err message - in case of authentication failure
			 * In case of successful authentication ,perform role based authorization &
			 * display as per the role doctor | patient details 
			 */
			//=> auth successful -> role based authorization
			if(user.getRole()==UserRole.ROLE_PATIENT)
			{
				PatientDao patientDao=new PatientDaoImpl();
				Patient patient = patientDao.getPatientDetails(user.getId());
				System.out.println("Common User  Details");
				System.out.println(user);
				System.out.println("Patient specific details");
				System.out.println(patient);
				System.out.println("Tests advised");
				patient.getDiagnosticTests().forEach(System.out::println);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
