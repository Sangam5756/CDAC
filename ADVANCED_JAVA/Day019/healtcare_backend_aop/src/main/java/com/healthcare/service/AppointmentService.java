package com.healthcare.service;

import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AppointmentResp;
import com.healthcare.dto.BookAppointment;

public interface AppointmentService {

	List<AppointmentDTO> listUpcomingPatientAppointments(Long patientId);

	AppointmentResp bookAppointment(Long pid, BookAppointment dto);

}
