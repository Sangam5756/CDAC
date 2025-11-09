package com.healthcare.service;

import com.healthcare.dto.AuthRequest;
import com.healthcare.dto.AuthResp;

public interface UserService {

	AuthResp signIn(AuthRequest reqDTO);

}
