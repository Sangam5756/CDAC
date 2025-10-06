package com.book.service;

import com.book.core.Book;
import com.book.core.BookFormat;
import com.book.core.BookType;
import com.book.core.Ebook;
import com.book.core.PrintBook;
import com.book.exception.BooksException;

public class Validation {

	public static void validateRating(int rating) throws BooksException {
		if (rating < 0 || rating > 5)
		    throw new BooksException("invalid rating exception");

	public static void validateTitle(String title) throws BooksException {
		if (title.length() < 3 && title.length() > 50)
			throw new BooksException("title length must be 1 to 50");
	}
	
	
	public static Book validatePrintBook(String title, String author, int rating, double price, boolean availableStock,
			String genre, int page, double weight) throws BooksException {

//		check the rating is in range 1 - 5
		validateRating(rating);

//		check the title is 3 -50 characters
		validateTitle(title);

//		validate enums
		BookType bookType = BookType.valueOf(genre.toUpperCase());

//		its printbook then return object of that
		return new PrintBook(title, author, rating, price, availableStock, bookType, page, weight);

	}
	
	public static Book validateEbook(String title, String author, int rating, double price, boolean availableStock, String genre,
			double filesize, String format) throws BooksException {

//		check the rating is in range 1 - 5
		validateRating(rating);

//		check the title is 3 -50 characters
		validateTitle(title);

//		validate enums
		BookType bookType = BookType.valueOf(genre.toUpperCase());
		BookFormat bookFormat= BookFormat.valueOf(format.toUpperCase());

//		its printbook then return object of that
		return new Ebook(title, author, rating, price, availableStock, bookType, filesize,bookFormat );

	}

}
