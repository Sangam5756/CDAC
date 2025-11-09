package com.healthcare.dto;

import java.time.LocalDateTime;

import com.healthcare.entities.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//{"appointmentId":101,"doctorName":"Dr. Priya Sharma","appointmentDateTime":"2025-11-05T10:30:00","status":"SCHEDULED","message":"Appointment booked successfully"}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResp {
	private Long appointmentId;
	private String doctorName;
	private LocalDateTime appointmentDateTime;
	private Status status;
	private String message;
}
