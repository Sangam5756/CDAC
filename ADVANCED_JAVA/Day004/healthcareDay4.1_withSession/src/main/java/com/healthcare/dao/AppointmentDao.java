package com.healthcare.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthcare.pojos.AppointmentDetails;

public interface AppointmentDao {

	public String BookAppointMent(int doctorId, int patientId, String appointmentDate) throws SQLException;
	public List<AppointmentDetails> DisplayAppointment(int patientId)throws SQLException;
	public int CancelAppointment(int appointmentId,int patientId)throws SQLException;
	public void cleanup() throws SQLException;

}
