package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.util.DBUtil;

public class BookDaoImpl implements BookDao {

	private Connection connection;
	private PreparedStatement pst1;

	public BookDaoImpl() throws SQLException {
		connection = DBUtil.getConnection();
		pst1 = connection.prepareStatement("select * from books");
	}

	@Override
	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new ArrayList<>();
//		here directly fetch the books
		ResultSet rs = pst1.executeQuery();
		while (rs.next()) {
			books.add(new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"),
					rs.getBoolean("available")));

		}
		return books;

	}

}
