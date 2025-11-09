package com.healthcare.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.AppointmentBookReq;
import com.healthcare.dto.AppointmentResponse;
import com.healthcare.entities.Status;
import com.healthcare.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientsController {

	private final AppointmentService appointmentService;

	@GetMapping("/{patientId}/appointments/upcoming")
	public ResponseEntity<?> getAppointments(@PathVariable Long patientId) {

		try {
//			first get the patientId from patient find the id 
			System.out.println("inside the controlller");
			return ResponseEntity
					.ok(appointmentService.getUpcomingAppointments(patientId, Status.SCHEDULED, LocalDateTime.now()));
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage(), "failed"));
		}

	}

	@PostMapping("/bookappointment")
	public ResponseEntity<?> bookAppointment(@RequestBody AppointmentBookReq bookAppReq) {
//		got the oayload from the request body we need to extract the information from that
		try {
			System.out.println(bookAppReq);
			AppointmentResponse newAppointment = appointmentService.bookAppointment(bookAppReq.getPatientId(),
					bookAppReq.getDoctorId(), bookAppReq.getAppointmentDateTime());

			return ResponseEntity.ok(newAppointment);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse(e.getMessage(), "failed"));
		}

	}

}
