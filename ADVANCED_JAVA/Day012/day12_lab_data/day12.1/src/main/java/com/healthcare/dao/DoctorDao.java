package com.healthcare.dao;

import com.healthcare.entities.Doctor;

public interface DoctorDao {
	String registerDoctor(Doctor doctor);
	Doctor getDoctorDetails(Long userId);	
}
