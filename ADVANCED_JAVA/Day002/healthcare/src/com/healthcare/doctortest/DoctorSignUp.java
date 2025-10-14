package com.healthcare.doctortest;

import java.sql.Date;
import java.util.Scanner;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.pojos.Doctor;

public class DoctorSignUp {

	public static void main(String[] args) {
		// init phase
		try (Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			DoctorDao dao = new DoctorDaoImpl();
			boolean exit=false;
			
				// clnt servicing phase
				System.out.println("Enter Doctor details - name, speciality, email, password,dob");
				Doctor doctor = new Doctor(sc.nextLine(), sc.next(), sc.next(), sc.next(), Date.valueOf(sc.next()));
				System.out.println("Reg status " + dao.signUp(doctor));
			

			// 3. destroy - clean up
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
