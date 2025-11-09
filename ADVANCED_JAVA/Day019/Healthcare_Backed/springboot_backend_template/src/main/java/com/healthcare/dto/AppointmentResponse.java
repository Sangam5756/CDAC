package com.healthcare.dto;

import java.time.LocalDateTime;

import com.healthcare.entities.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponse {

	private Long appointmentId;
	private LocalDateTime appointmentDateTime;
	private String doctorName;
	private Status status;
	private String message;

}
