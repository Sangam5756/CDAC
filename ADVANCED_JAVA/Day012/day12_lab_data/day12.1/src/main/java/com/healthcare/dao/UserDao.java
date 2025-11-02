package com.healthcare.dao;

import com.healthcare.entities.User;

public interface UserDao {
	User signIn(String email, String password);
}
