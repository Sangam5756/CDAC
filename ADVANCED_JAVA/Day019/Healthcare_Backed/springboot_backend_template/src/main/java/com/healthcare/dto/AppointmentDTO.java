package com.healthcare.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppointmentDTO {

	private Long appointmentId;
	private LocalDateTime appointmentTS;
	private String firstName;
	private String lastName;

}
