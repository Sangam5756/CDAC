package com.healthcare.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

/*
 *  "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string",
    "phone": "string",
    "dob": "string",
    "regAmount": 0
 */
@Getter
@Setter
public class UserReqDTO {
	private String firstName;	
	private String lastName;
	private String email;	
	private String password;
	private String phone;
	@Past
	private LocalDate dob;
	private int regAmount;

}
