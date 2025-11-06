package com.healthcare.service;

import java.time.LocalDateTime;
import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AppointmentResponse;
import com.healthcare.entities.Status;

public interface AppointmentService {
	public List<AppointmentDTO> getUpcomingAppointments(Long patientId,Status st,LocalDateTime time);
	public AppointmentResponse bookAppointment(Long patientId,Long DoctorId,LocalDateTime ts);
}
