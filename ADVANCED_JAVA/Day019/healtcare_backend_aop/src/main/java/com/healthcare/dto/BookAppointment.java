package com.healthcare.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BookAppointment {
	private Long doctorId;
	private LocalDateTime appointmentDateTime;
}
