package com.onlinevoting.dao;

import java.sql.SQLException;

import com.onlinevoting.model.Voter;

public interface VoterDao extends BaseDao {

	public Voter voterLogin(String email, String password) throws SQLException;

	public int voteCandidate(int voterId,int candidateId) throws SQLException;

}
