package com.healthcare.dao;

import java.util.List;

import com.healthcare.entities.User;

public interface UserDao {

	User signIn(String email, String pwd);
	// list all users
	List<User> listUsers();

}
