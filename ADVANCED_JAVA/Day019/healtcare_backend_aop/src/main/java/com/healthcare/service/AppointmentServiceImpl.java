package com.healthcare.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceAlreadyExists;
import com.healthcare.custom_exceptions.ResourceNotFoundException;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AppointmentResp;
import com.healthcare.dto.BookAppointment;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
	private final AppointmentRepository appointmentRepository;
	private final PatientRepository patientRepository;
	private final DoctorRepository doctorRepository;

	@Override
	public List<AppointmentDTO> listUpcomingPatientAppointments(Long patientId) {
		// by patient id
		return appointmentRepository.getPatientUpcomingAppointmentsByPatientId(patientId, Status.SCHEDULED);
		// by user id
//		return appointmentRepository.getPatientUpcomingAppointmentsByUserId2(userId,Status.SCHEDULED,LocalDateTime.now());

	}

	@Override
	public AppointmentResp bookAppointment(Long pid, BookAppointment dto) {
		// 1. validate patient id
		Patient patient = patientRepository.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Patient ID!!!!"));
		// 2. validate doc id
		Doctor doctor = doctorRepository.findById(dto.getDoctorId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Doctor ID!!!!"));
		// 3. check doc's availability
		if (!appointmentRepository.existsByMyDoctorIdAndAppointmentDateTime(dto.getDoctorId(),
				dto.getAppointmentDateTime())) {
			// => available -> book appointment
			Appointment appointment = new Appointment();
			appointment.setAppointmentDateTime(dto.getAppointmentDateTime());
			// Appointment * --->1 Patient
			appointment.setMyPatient(patient);
			// Appointment * --->1 Doctor
			appointment.setMyDoctor(doctor);
			Appointment entity = appointmentRepository.save(appointment);
			// create Resp DTO
			AppointmentResp respDto = new AppointmentResp(entity.getId(), doctor.getUserDetails().getLastName(),
					dto.getAppointmentDateTime(), Status.SCHEDULED, "Appointment Booked !");
			return respDto;
		} else
			throw new ResourceAlreadyExists("Appointment un available");

	}

}
