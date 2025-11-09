package com.healthcare.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.AuthenticationException;
import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResp;
import com.healthcare.entities.User;
import com.healthcare.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	//depcy
	private final UserRepository userRepository;
	private final ModelMapper modelMapper;

	@Override
	public AuthResp signIn(AuthRequest dto) {
		// invoke dao's method
		User entity=userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword()) //Optional<User>
		.orElseThrow(() -> new AuthenticationException("Invalid Email or password"));
		//convert entity -> dto (resp)
		AuthResp respDTO = modelMapper.map(entity, AuthResp.class);
		respDTO.setMessage("Login Successful.....");
		return respDTO;
	}

}
