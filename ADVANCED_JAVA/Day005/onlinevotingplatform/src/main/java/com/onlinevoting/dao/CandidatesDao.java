package com.onlinevoting.dao;

import java.sql.SQLException;
import java.util.List;

import com.onlinevoting.dto.CandidateNameDto;

public interface CandidatesDao extends BaseDao {

	public List<CandidateNameDto> listAllCandidatesNames() throws SQLException;

	
}
