package com.healthcare.dto;

import com.healthcare.entities.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

	private String firstName;
	private String lastName;
	private String email;
	private UserRole role;
	private String message;

}
