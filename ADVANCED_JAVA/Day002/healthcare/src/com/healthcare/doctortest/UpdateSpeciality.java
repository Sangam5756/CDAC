package com.healthcare.doctortest;

import java.sql.Date;
import java.util.Scanner;

import com.healthcare.dao.DoctorDao;
import com.healthcare.dao.DoctorDaoImpl;
import com.healthcare.pojos.Doctor;

public class UpdateSpeciality {

	public static void main(String[] args) {
		// init phase
		try (Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			DoctorDao dao = new DoctorDaoImpl();

			// clnt servicing phase
			System.out.println("Enter Doctor id , new speciality");
			System.out.println("Updation status " + dao.updateSpeciality(sc.nextInt(), sc.next()));

			// 3. destroy - clean up
			dao.cleanUp();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
