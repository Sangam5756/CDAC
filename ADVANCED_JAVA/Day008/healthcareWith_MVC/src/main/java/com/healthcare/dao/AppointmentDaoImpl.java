package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.closeConnection;
import static com.healthcare.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.AppointmentDetailsDto;

public class AppointmentDaoImpl implements AppointmentDao {

	private Connection connection;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	private PreparedStatement pst3;

	public AppointmentDaoImpl() throws SQLException {
		connection = openConnection();
		pst1 = connection
				.prepareStatement("insert into appointments(doctor_id,patient_id,appointment_datetime) values (?,?,?)");
		pst2 = connection.prepareStatement(
				"select a.id , a.appointment_datetime ,d.name from appointments a join doctors d on a.doctor_id=d.id where a.patient_id=? and  status='SCHEDULED' ");
		pst3 = connection.prepareStatement("update appointments set status='CANCELED' where id=? and patient_id=? and appointment_datetime > now()");

	}

	@Override
	public String BookAppointMent(int doctorId, int patientId, String appointmentDate) throws SQLException {
		pst1.setInt(1, doctorId);
		pst1.setInt(2, patientId);
		pst1.setDate(3, Date.valueOf(appointmentDate));

		int rs = pst1.executeUpdate();
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
		if (pst2 != null) {
			pst2.close();
			pst2 = null;
		}

		closeConnection();

	}

	@Override
	public List<AppointmentDetailsDto> DisplayAppointment(int id) throws SQLException {

//		call the appoinment display
		pst2.setInt(1,id);
		ResultSet rs = pst2.executeQuery();
		List<AppointmentDetailsDto> appointment = new ArrayList<>();
		while (rs.next()) {
			appointment.add(new AppointmentDetailsDto(rs.getInt(1), rs.getTimestamp(2), rs.getString(3)));
		}

		return appointment;

	}

	@Override
	public int CancelAppointment(int appointmentId, int patientId) throws SQLException {
		pst3.setInt(1, appointmentId);
		pst3.setInt(2,patientId);
		
		int rows = pst3.executeUpdate();
		System.out.println("patientid and appintmenid"+appointmentId+"  patieint"+patientId);
		
		return rows;
		
	}
	
}
