package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.closeConnection;
import static com.healthcare.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.healthcare.pojos.Patient;

public class PatientDaoImpl implements PatientDao {
	// state
	private Connection cn;
	private PreparedStatement pst1;

	public PatientDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// create pst1 - login
		pst1 = cn.prepareStatement("select * from patients where email=? and password=?");
		System.out.println("patient dao created");

	}

	@Override
	public Patient signIn(String email, String password) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, password);
		try (ResultSet rst = pst1.executeQuery()) {
			// int id, String name, String email, String phone, Date dob
			if (rst.next()) {
				return new Patient(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(5), rst.getDate(6));
			}
		}
		return null;
	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		closeConnection();
		System.out.println("patient dao cleaned up");

	}

}
