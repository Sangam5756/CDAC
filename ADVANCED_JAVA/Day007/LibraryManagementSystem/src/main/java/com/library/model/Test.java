package com.library.model;

import java.sql.SQLException;

import com.library.dao.UserDao;
import com.library.dao.UserDaoImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		try {
			UserDao dao = new UserDaoImpl();
				
			dao.loginUser("ravi@student.com", "ravi123");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
