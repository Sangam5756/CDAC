package com.healthcare.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exception.ResourceNotFoundException;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AppointmentResponse;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;
import com.healthcare.repositories.AppointmentRepository;
import com.healthcare.repositories.DoctorRepository;
import com.healthcare.repositories.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentsImpl implements AppointmentService {

	private final AppointmentRepository appointmentRepository;
	private final PatientRepository patientRepository;
	private final DoctorRepository doctorRepository;

	@Override
	public List<AppointmentDTO> getUpcomingAppointments(Long patientId, Status st, LocalDateTime time) {
		// TODO Auto-generated method stub
		System.out.println("inside the repo");
		return appointmentRepository.getUpcomingAppointments(patientId, st, time);
	}

	@Override
	public AppointmentResponse bookAppointment(Long patientId, Long DoctorId, LocalDateTime ts) {

//		check patient is valid
		Patient isValidPatient = patientRepository.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("patient is invalid"));
		// check the doctor is valid
		Doctor isValidDoctor = doctorRepository.findById(DoctorId)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor is invalid"));

//		check the appointment is avaialbe or not
		Optional<Appointment> existingAppointment = appointmentRepository
				.findByMyDoctorAndAppointmentDateTime(isValidDoctor, ts);

		if (existingAppointment.isPresent()) {
			throw new RuntimeException("Appointment slot is already booked for this doctor and time!");
		}

//		now we no that the appointment is available so insert into  appointments
		Appointment newApp = new Appointment(ts, Status.SCHEDULED, isValidDoctor, isValidPatient);
		appointmentRepository.save(newApp);
		System.out.println(newApp);

//		add mapper to map to appointment response
//		AppointmentResponse appRes = mapper.map(newApp, AppointmentResponse.class);
		AppointmentResponse appRes = new AppointmentResponse();
		appRes.setAppointmentDateTime(newApp.getAppointmentDateTime());
		appRes.setAppointmentId(newApp.getId());
		appRes.setDoctorName(isValidDoctor.getUserDetails().getFirstName());
		appRes.setStatus(newApp.getStatus());
		appRes.setMessage("Appointment Book Successfully");
		return appRes;
	}

}
