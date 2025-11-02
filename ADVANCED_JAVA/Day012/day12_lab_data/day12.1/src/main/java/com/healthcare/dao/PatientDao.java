package com.healthcare.dao;

import com.healthcare.entities.Patient;

public interface PatientDao {
	String registerPatient(Patient Patient);
	Patient getPatientDetails(Long userId);
	
	
}
