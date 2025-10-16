package com.healthcare.dao;

import java.sql.SQLException;

public interface AppointmentDao {

	public String BookAppointMent(int doctorId, int patientId, String appointmentDate) throws SQLException;

	public void cleanup() throws SQLException;

}
