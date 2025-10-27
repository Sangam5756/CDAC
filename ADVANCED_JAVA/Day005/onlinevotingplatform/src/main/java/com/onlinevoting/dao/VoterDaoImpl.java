package com.onlinevoting.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinevoting.model.Voter;
import com.onlinevoting.util.DBUtils;

public class VoterDaoImpl implements VoterDao {

	private Connection conn;
	private PreparedStatement pst1;
	private CallableStatement pst2;
	private PreparedStatement pst3;

	public VoterDaoImpl() throws SQLException {
		conn = DBUtils.openConnection();
//		for checking the prepareStatement for the check login
		pst1 = conn.prepareStatement("select * from users where email = ? and password = ?");
		pst2 = conn.prepareCall("{call voteCandidate(?,?)}");
		pst3 = conn.prepareStatement("select status from users  where id=?");
	}

	@Override
	public Voter voterLogin(String email, String password) throws SQLException {
//			now set the preparedStatement attributes
		pst1.setString(1, email);
		pst1.setString(2, password);

//		see we are just executing the query so just use exceuteQuery as
//		it will return the user in result set so we can use it to store in session
		ResultSet result = pst1.executeQuery();
		Voter existingVoter = null;

		while (result.next()) {
			existingVoter = new Voter(result.getInt(1), result.getString(2), result.getString(3), result.getString(4),
					result.getString(5), result.getDate(6), result.getInt(7), result.getString(8));
		}

//		if user is present the return
		if (existingVoter != null) {
			return existingVoter;
		}
		return null;
	}

	@Override
	public int voteCandidate(int voterId, int candidateId) throws SQLException {
//		here update the candidate status to true as he voted
//		first check the user already voted or not
		pst3.setInt(1, voterId);
		
		if(pst3.execute()) {
			return 0;
		}
		
		pst2.setInt(1, voterId);
		pst2.setInt(2, candidateId);
		pst2.execute();
		int count = pst2.getUpdateCount();
		
		return count;
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
		DBUtils.closeConnection();

	}

}
