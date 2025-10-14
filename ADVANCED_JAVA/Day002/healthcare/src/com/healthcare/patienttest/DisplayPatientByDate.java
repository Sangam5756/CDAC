package com.healthcare.patienttest;

import java.util.Scanner;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

public class DisplayPatientByDate {

	public static void main(String[] args) {
		// init phase

		try (Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			PatientDao patient = new PatientDaoImpl();
			
			System.out.println("Enter the startdate and enddate to see patient reports by dob");
			
			patient.displayPatientByDobDate(sc.next(), sc.next());

			patient.cleanup();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
