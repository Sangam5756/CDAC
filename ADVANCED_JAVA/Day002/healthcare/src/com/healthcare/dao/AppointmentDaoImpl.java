package com.healthcare.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static com.healthcare.utils.DBUtils.*;

public class AppointmentDaoImpl implements AppointmentDao {

	private Connection connection;
	private PreparedStatement pst1;

	public AppointmentDaoImpl() throws SQLException {
		connection = openConnection();
		pst1 = connection
				.prepareStatement("insert into appointments(doctor_id,patient_id,appointment_datetime) values (?,?,?)");
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
		if(pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		
		closeConnection();
		
	}
}

