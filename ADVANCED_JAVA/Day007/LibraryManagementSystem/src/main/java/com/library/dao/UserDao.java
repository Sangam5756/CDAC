package com.library.dao;

import java.sql.SQLException;

import com.library.exceptions.LibraryException;
import com.library.model.User;

public interface UserDao {

//	login user
	public User loginUser(String email, String password) throws SQLException, LibraryException;

//	signup user
	public User signupUser(String name, String email, String role, String password) throws SQLException;

}
