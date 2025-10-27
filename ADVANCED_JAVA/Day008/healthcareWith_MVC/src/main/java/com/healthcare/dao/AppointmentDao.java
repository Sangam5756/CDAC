package com.healthcare.dao;

import java.sql.SQLException;
import java.util.List;

import com.healthcare.dto.AppointmentDetailsDto;

public interface AppointmentDao extends BaseDao {

	public String BookAppointMent(int doctorId, int patientId, String appointmentDate) throws SQLException;
	public List<AppointmentDetailsDto> DisplayAppointment(int patientId)throws SQLException;
	public int CancelAppointment(int appointmentId,int patientId)throws SQLException;

}
