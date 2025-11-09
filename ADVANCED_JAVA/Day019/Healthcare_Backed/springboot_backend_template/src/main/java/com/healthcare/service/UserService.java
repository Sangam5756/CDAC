package com.healthcare.service;

import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResponse;

public interface UserService {

//	here will return the response object
	AuthResponse loginUser(AuthRequest user);
	
	
	
	
}
