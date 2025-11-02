package com.healthcare.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.healthcare.dto.AppointmentDTO;

public interface AppointmentDao {
	
	// book an appointment
	String bookAppointment(Long doctorId, Long patientId, LocalDateTime ts);

	// cancel appointment
	String cancelAppointment(Long appointmentId, Long patientId);

	// list specific patient's upcoming appointments
	List<AppointmentDTO> listUpcomingAppointmentsForPatient(Long patientId);

	// list specific doctor's upcoming appointments
	List<AppointmentDTO> listUpcomingAppointmentsForDoctor(Long doctorId);

}
