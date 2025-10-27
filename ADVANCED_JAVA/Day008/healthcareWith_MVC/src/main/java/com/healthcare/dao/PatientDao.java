package com.healthcare.dao;

import java.sql.SQLException;

import com.healthcare.pojos.Patient;

public interface PatientDao extends BaseDao {

	/*
	 * 4.1 Patient sign in i/p - email , password o/p - Patient details (via Patient
	 * POJO ) or error message.
	 */

	public Patient patientSignin(String email, String password) throws SQLException;

	public void displayPatientByDobDate(String startDate, String endDate) throws SQLException;

	public String deletePatient(int patientId) throws SQLException;

	public String BookAppointMent(int doctorId, int patientId, String appointmentDate) throws SQLException;

}
