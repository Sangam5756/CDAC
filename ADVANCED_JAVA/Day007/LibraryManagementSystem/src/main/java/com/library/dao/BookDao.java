package com.library.dao;

import java.sql.SQLException;
import java.util.List;

import com.library.model.Book;

public interface BookDao {
	
	
	public List<Book> getAllBooks() throws SQLException;
}
