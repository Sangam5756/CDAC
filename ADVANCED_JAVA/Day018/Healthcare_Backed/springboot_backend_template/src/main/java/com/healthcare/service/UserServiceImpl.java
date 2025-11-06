package com.healthcare.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exception.AuthenticationException;
import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResponse;
import com.healthcare.entities.User;
import com.healthcare.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final ModelMapper mapper;

	@Override
	public AuthResponse loginUser(AuthRequest user) {
//		do the validation of data 
//		check whether the user exist
		User isExist = userRepository.findByEmail(user.getEmail())
				.orElseThrow(() -> (new AuthenticationException("User doesnt not exist")));
//if password not match
//		if exist then check password then if valid then return response
		if (!isExist.getPassword().equals(user.getPassword())) {
			new AuthenticationException("Invalid email and password");
		}

		AuthResponse authDto = mapper.map(isExist, AuthResponse.class);
		authDto.setMessage("Login Successfull");
		return authDto;
	}

}
