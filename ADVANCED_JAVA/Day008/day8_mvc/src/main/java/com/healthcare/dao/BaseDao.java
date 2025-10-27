package com.healthcare.dao;

import java.sql.SQLException;

public interface BaseDao {
	//clean up
		void cleanUp() throws SQLException;
}
