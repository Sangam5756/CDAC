package com.healthcare.patienttest;

import java.util.Scanner;

import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

public class DeletePatientById {

	public static void main(String[] args) {
		// init phase
		try (Scanner sc = new Scanner(System.in)) {
			// 1. create dao instance
			PatientDao patient = new PatientDaoImpl();

			System.out.println("Enter the patientId to delete");

			System.out.println(patient.deletePatient(sc.nextInt()));

			patient.cleanup();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
