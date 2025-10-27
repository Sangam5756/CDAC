package com.onlinevoting.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.onlinevoting.dto.CandidateNameDto;
import com.onlinevoting.util.DBUtils;

public class CandidatesDaoImpl implements CandidatesDao {

	private Connection conn;
	private PreparedStatement pst1;

	public CandidatesDaoImpl() throws SQLException {
		conn = DBUtils.openConnection();
		pst1 = conn.prepareStatement("select id,name from candidates");

	}

	@Override
	public List<CandidateNameDto> listAllCandidatesNames() throws SQLException {
//			here we don't need to setup the parameter
//		here direct we can call pst2 
		ResultSet result = pst1.executeQuery();

//		will create the Arraylist to add the candidates
		List<CandidateNameDto> candidates = new ArrayList<>();
		while (result.next()) {
			candidates.add(new CandidateNameDto(result.getInt(1),result.getString(2)));
		}
		return candidates;
	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();
			pst1 = null;
		}

		DBUtils.closeConnection();
	}

}
