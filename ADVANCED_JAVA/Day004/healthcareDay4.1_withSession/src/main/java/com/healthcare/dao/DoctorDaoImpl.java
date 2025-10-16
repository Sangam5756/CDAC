package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.closeConnection;
import static com.healthcare.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.pojos.Doctor;

public class DoctorDaoImpl implements DoctorDao {
	// state
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public DoctorDaoImpl() throws SQLException {
		// open cn
		cn = openConnection();
		// create pst1 - finder method : speciality
		pst1 = cn.prepareStatement("select * from doctors where speciality=?");
		// pst2 - insert query
		pst2 = cn.prepareStatement("INSERT INTO doctors (name, speciality, email, password,dob) VALUES(?,?,?,?,?)");
		// pst3 - update
		pst3 = cn.prepareStatement("update doctors set speciality=? where id=?");
		System.out.println("doc dao created...");

	}

	@Override
	public List<Doctor> findBySpeciality(String speciality) throws SQLException {
		List<Doctor> doctors = new ArrayList<>();
		// set IN parameter
		pst1.setString(1, speciality);
		// select query -> exec query -> RST -> process it
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * int id, String docName, String speciality, String email, Date dob
			 */
			while (rst.next())
				doctors.add(new Doctor(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getDate(6)));
		}
		return doctors;
	}

	@Override
	public String signUp(Doctor newDoctor) throws SQLException {
		// 1. set IN params - name, speciality, email, password,dob
		pst2.setString(1, newDoctor.getDocName());
		pst2.setString(2, newDoctor.getSpeciality());
		pst2.setString(3, newDoctor.getEmail());
		pst2.setString(4, newDoctor.getPassword());
		pst2.setDate(5, newDoctor.getDob());
		// 2 execution method - executeUpdate
		int rows = pst2.executeUpdate();
		return "Doc registration successful !";
	}

	@Override
	public String updateSpeciality(int doctorId, String newSpeciality) throws SQLException {
		// 1. set IN params
		pst3.setString(1, newSpeciality);
		pst3.setInt(2, doctorId);
		int rowCount = pst3.executeUpdate();
		if (rowCount == 1)
			return "Speciality updated ....";
		return "Updation Failed !!!!!!!!!";
	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}
		if (pst2 != null) {
			pst2.close();
			pst2 = null;
		}
		if (pst3 != null) {
			pst3.close();
			pst3 = null;
		}
		closeConnection();

	}

}
