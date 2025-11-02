package com.healthcare.service;

import java.util.List;

import com.healthcare.entities.User;

public interface UserService {

	List<User> listUsers();

	User signIn(String email,String password);
}
