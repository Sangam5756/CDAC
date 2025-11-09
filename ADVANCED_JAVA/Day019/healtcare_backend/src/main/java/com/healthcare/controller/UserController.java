package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.AuthRequest;
import com.healthcare.service.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
	//depcy
	private final UserService userService;
	/*
	 * 1. Patient Login / Doctor Login(User Login)  common
- Controller
 - UserController
URL - http://host:port/users/signin
Method - POST  (for security , JWT generation, JSON payload)
Eg . Patient Logs in 
Payload - email , password  (Auth Request DTO)
Success Resp -Sc 200 |201  Auth Resp DTO (user id ,name, email , role , message)
Failure Resp - SC 401 ApiResp DTO(status : succes | failure , timestamp , message)

	 */
	@PostMapping("/signin")
	public /* @ResponseBody */ ResponseEntity<?> userAuthentication(@RequestBody @Valid AuthRequest dto)
	{
		System.out.println("in user auth "+dto);
		//invoker service layer method
		
			return ResponseEntity.ok(userService.signIn(dto));
		
	}
	

}
