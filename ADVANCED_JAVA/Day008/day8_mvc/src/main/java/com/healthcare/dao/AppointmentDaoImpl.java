package com.healthcare.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import static com.healthcare.utils.DBUtils.*;

public class AppointmentDaoImpl implements AppointmentDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3, pst4;

	// def ctor
	public AppointmentDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// get appointments
		pst1 = cn.prepareStatement(
				"select a.id,a.appointment_datetime,d.name from appointments a join doctors d on a.doctor_id=d.id where a.patient_id=? and a.status='SCHEDULED' order by a.appointment_datetime desc");
		// pst2 - checking doc availability
		pst2 = cn.prepareStatement("select id from appointments where doctor_id=? and appointment_datetime=?");
		// pst3 -book appointment
		pst3 = cn.prepareStatement("insert into appointments(doctor_id,patient_id,appointment_datetime) values(?,?,?)");
		// pst4 - cancel appointment
		pst4 = cn.prepareStatement(
				"update appointments set status='CANCELLED' where id=? and patient_id=? and appointment_datetime> now()");
	}

	@Override
	public List<AppointmentDTO> listAllUpcomingAppoints(int patientId) throws SQLException {
		List<AppointmentDTO> list = new ArrayList<>();
		// set IN param
		pst1.setInt(1, patientId);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				list.add(new AppointmentDTO(rst.getInt(1), rst.getTimestamp(2), rst.getString(3)));
			}
		}
		return list;
	}

	@Override
	public String bookAppointment(int doctorId, int patientId, Timestamp ts) throws SQLException {
		if (isDoctorAvailable(doctorId, ts)) {
			// => doc available
			pst3.setInt(1, doctorId);
			pst3.setInt(2, patientId);
			pst3.setTimestamp(3, ts);
			int rows = pst3.executeUpdate();
			if (rows == 1)
				return "Appoinment booked!";
			return "Error in booking appointment !";
		}
		return "Appointment un available !!!!";
	}

	// add private method to check doc's availability
	private boolean isDoctorAvailable(int docId, Timestamp ts) throws SQLException {
		pst2.setInt(1, docId);
		pst2.setTimestamp(2, ts);
		try (ResultSet rs = pst2.executeQuery()) {
			if (rs.next()) {
				return false;
			}

		}
		return true;

	}

	@Override
	public String cancelAppointment(int appointmentId, int patientId) throws SQLException {
		// set IN params
		pst4.setInt(1, appointmentId);
		pst4.setInt(2, patientId);
		int rows = pst4.executeUpdate();
		if (rows == 1) {
			return "Appoinment cancelled !";
		}
		return "Error in cancelling appointment - can't cancel earlier appointments!!!!";

	}

	@Override
	public void cleanUp() throws SQLException {
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

	}

}
