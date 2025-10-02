package com.book.service;

import com.book.exception.BooksException;

public interface BookService {

	public void addEBook(String title, String author, int rating, double price, boolean availableStock, String genre,
			double filesize, String format) throws BooksException;
	public void addPrintBook(String title, String author, int rating, double price, boolean availableStock, String genre,int page,double weight
			) throws BooksException;
	public void displayAllBook();
	public void displayAllBookSortedByid();
	public void searchMostExpensiveBook();
	public void removeAllNotAvailableBook();
	public String updateBookPrice(int bookId,double price);
	public void sortBookBypriceAsc();
	
	
}
