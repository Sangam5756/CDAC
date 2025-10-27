package com.healthcare.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthcare.pojos.Doctor;

public interface DoctorDao extends BaseDao {
//get all docs from specified specialty
	List<Doctor> findBySpeciality(String speciality) throws SQLException;

	String signUp(Doctor newDoctor) throws SQLException;

	String updateSpeciality(int doctorId,String newSpeciality) throws SQLException;

}
