package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.exceptions.LibraryException;
import com.library.model.ROLE;
import com.library.model.User;
import com.library.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private Connection connection;
	private PreparedStatement isExistPst;
	private PreparedStatement getUserPst;

	public UserDaoImpl() throws SQLException {
		connection = DBUtil.getConnection();
		isExistPst = connection.prepareStatement("select email from users where email =?");
		getUserPst = connection.prepareStatement("select * from users where email =? and password=?");
	}

	public boolean isUserExists(String email) throws SQLException {
		isExistPst.setString(1, email);
		ResultSet set = isExistPst.executeQuery();
		return set.next();
	}

	@Override
	public User loginUser(String email, String password) throws LibraryException, SQLException {
		boolean ps = isUserExists(email);
		if (!ps) {
			throw new LibraryException("User Not found ");
		}

//		match email and password
		User user = null;
		getUserPst.setString(1, email);
		getUserPst.setString(2, password);

		ResultSet res = getUserPst.executeQuery();
		while (res.next()) {
			user = new User(res.getInt(1), res.getString(2), res.getString(3), null, ROLE.valueOf(res.getString(5)));
		}

		System.out.println(user);
		return user;
	}

	@Override
	public User signupUser(String name, String email, String role, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
