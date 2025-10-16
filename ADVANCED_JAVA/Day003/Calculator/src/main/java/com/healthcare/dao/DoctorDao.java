package com.healthcare.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthcare.pojos.Doctor;

public interface DoctorDao {
//get all docs from specified specialty
	List<Doctor> findBySpeciality(String speciality) throws SQLException;
	//doc signup
	String signUp(Doctor newDoctor) throws SQLException;
	/*
	 * Update speciality
i/p - doctor id , new speciality
	 */
	String updateSpeciality(int doctorId,String newSpeciality) throws SQLException;
	//clean up
	void cleanUp() throws SQLException;
}
