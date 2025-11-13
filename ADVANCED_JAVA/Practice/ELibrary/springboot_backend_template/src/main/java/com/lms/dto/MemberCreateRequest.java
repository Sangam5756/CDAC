package com.lms.dto;

import com.lms.entity.MemberShipType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class MemberCreateRequest {


	@NotBlank(message = "member name is required")
	private String name;
	
	@NotBlank(message = "member email is required")
	@Email
	private String email;

	
	@NotBlank(message = "memeber password is required")
	private String password;

	
	private MemberShipType membershipType;
	
	
	
}
