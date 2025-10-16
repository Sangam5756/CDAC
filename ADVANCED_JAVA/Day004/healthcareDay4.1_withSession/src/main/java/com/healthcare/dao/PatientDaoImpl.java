package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthcare.pojos.Patient;

public class PatientDaoImpl implements PatientDao {

	private Connection connection;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;
	private PreparedStatement pst4;

	public PatientDaoImpl() throws SQLException {
		connection = openConnection();
		pst1 = connection.prepareStatement("select * from Patients where email=? and password= ?");
		pst2 = connection.prepareStatement("select * from patients where dob between ? and ?");
		pst3 = connection.prepareStatement("DELETE FROM patients where id = ?");
		pst4 = connection
				.prepareStatement("insert into appointments(doctor_id,patient_id,appointment_datetime) values (?,?,?)");

	}

	@Override
	public Patient patientSignin(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);

		ResultSet st = pst1.executeQuery();
		Patient p = null;
		while (st.next()) {
			p = new Patient(st.getInt(1), st.getString(2), st.getString(3), st.getString(4), st.getString(5), st.getDate(6));
		}
		return p;

	}

	@Override
	public void displayPatientByDobDate(String startDate, String endDate) throws SQLException {
		pst2.setDate(1, Date.valueOf(startDate));
		pst2.setDate(2, Date.valueOf(endDate));

		ResultSet rs = pst2.executeQuery();

		while (rs.next()) {
			System.out.printf(" id %d name   %s email %s password %s dob %s %n", rs.getInt(1), rs.getString(2),
					rs.getString(3), rs.getString(4), rs.getString(5));

		}

	}

	@Override
	public String deletePatient(int patientId) throws SQLException {
		pst3.setInt(1, patientId);

		int result = pst3.executeUpdate();
		if (result == 1) {
			return "patient delete successfully";
		}

		return "failed to delete patient with id " + patientId;
	}

	@Override
	public String BookAppointMent(int doctorId, int patientId, String appointmentDate) throws SQLException {
		pst4.setInt(1, doctorId);
		pst4.setInt(2, patientId);
		pst4.setDate(3, Date.valueOf(appointmentDate));

		int rs = pst4.executeUpdate();
		if (rs == 1) {
			return "Successfully booked the apointment";
		}
		return "failed to book the appointment";
	}

	@Override
	public void cleanup() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		if (pst2 != null) {
			pst2.close();
			pst2 = null;
		}
		if (pst3 != null) {
			pst3.close();
			pst3 = null;
		}
		if (pst4 != null) {
			pst4.close();
			pst4 = null;
		}
		closeConnection();
		closeConnection();

	}

}
