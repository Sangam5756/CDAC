package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResponse;
import com.healthcare.service.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AuthController {

	private final UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest user) {
		System.out.println(user);
		try {
			AuthResponse userResponse = userService.loginUser(user);

			return ResponseEntity.ok(userResponse);

		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage(), "failed"));
		}

	}

}
