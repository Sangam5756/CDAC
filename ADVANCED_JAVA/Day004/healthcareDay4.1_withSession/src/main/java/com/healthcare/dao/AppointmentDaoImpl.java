package com.healthcare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.pojos.AppointmentDetails;

import static com.healthcare.utils.DBUtils.*;

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
				"select a.id , a.appointment_datetime ,d.name from appointments a join doctors d on a.doctor_id=d.id where a.patient_id=? and a.appointment_datetime > now() and status='SCHEDULED' ");
		pst3 = connection.prepareStatement("update appointments set status='Canceled' where id=? and patient_id=? and appointment_datetime <> now()");
		
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

		closeConnection();

	}

	@Override
	public List<AppointmentDetails> DisplayAppointment(int id) throws SQLException {

//		call the appoinment display
		pst2.setInt(1,id);
		ResultSet rs = pst2.executeQuery();
		List<AppointmentDetails> appointment = new ArrayList<>();
		while (rs.next()) {
			appointment.add(new AppointmentDetails(rs.getInt(1), rs.getTimestamp(2), rs.getString(3)));
		}

		return appointment;

	}

	@Override
	public int CancelAppointment(int appointmentId, int patientId) throws SQLException {
		pst3.setInt(1, appointmentId);
		pst3.setInt(2,patientId);
		
		int rows = pst3.executeUpdate();
		
		return rows;
		
	}
}
