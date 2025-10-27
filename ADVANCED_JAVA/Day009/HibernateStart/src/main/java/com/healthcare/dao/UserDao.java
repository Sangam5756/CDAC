package com.healthcare.dao;

import com.healthcare.entities.User;

public interface UserDao {
//add a method to register(sign up) new user
	String signUp(User newUser);
}
