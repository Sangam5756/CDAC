package com.healthcare.patienttest;

import java.util.Scanner;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

public class PatientSignin {

	public static void main(String[] args) {
		// init phase
		try (Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			PatientDao patient = new PatientDaoImpl();

			System.out.print("Enter email and password to Login");
			Patient p =patient.patientSignin(sc.next(), sc.next());
			if(p !=null) {
				System.out.println("User Succesfully Login");
				System.out.println(p);
			}else {
				System.out.println("invalid credential");
			}
			
//			patient.cleanup();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
