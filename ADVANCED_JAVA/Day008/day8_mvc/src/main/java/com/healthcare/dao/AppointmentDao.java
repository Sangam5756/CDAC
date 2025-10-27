package com.healthcare.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.healthcare.dto.AppointmentDTO;

public interface AppointmentDao extends BaseDao{
//list all upcoming appointments for specific patient
	List<AppointmentDTO> listAllUpcomingAppoints(int patientId) throws SQLException;

	// book an appointment
	String bookAppointment(int doctorId, int patientId, Timestamp ts) throws SQLException;
	// cancel appointment
	String cancelAppointment(int appointmentId,int patientId) throws SQLException;
	
}
