package com.healthcare.dto;
/*Data Transfer object - meant to transfer the data between the layers DAO-> Servlet
 * Later - it will be used to transfer the data REST client & REST server
 * Then it will be used to transfer the data between different MS
 */

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentDTO {
	private Long appointmentId;
	private LocalDateTime appointmentTS;
	private String firstName;
	private String lastName;
}
