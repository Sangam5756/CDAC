package com.book.service;

import static com.book.service.Validation.validateEbook;
import static com.book.service.Validation.validatePrintBook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.book.core.Book;
import com.book.exception.BooksException;

public class BookServiceImpl implements BookService {

//	as its asked to do crud in constant time
	HashMap<Integer, Book> books = new HashMap<>();

	@Override
	public void addEBook(String title, String author, int rating, double price, boolean availableStock, String genre,
			double filesize, String format) throws BooksException {

//		get the data pass data to validation level
		Book b = validateEbook(title, author, rating, price, availableStock, genre, filesize, format);
		books.put(b.getBookid(), b);

	}

	@Override
	public void addPrintBook(String title, String author, int rating, double price, boolean availableStock,
			String genre, int page, double weight) throws BooksException {
		Book b = validatePrintBook(title, author, rating, price, availableStock, genre, page, weight);
		books.put(b.getBookid(), b);

	}

	@Override
	public void displayAllBook() {
//		books.values().forEach((p) -> System.out.println(p));
		books.forEach((k,v) -> System.out.println(k+""+v));
		
	}

	@Override
	public void displayAllBookSortedByid() {
		// TODO Auto-generated method stub
//			book id is unique so will implement the comarable
		List<Book> b = new ArrayList<>(books.values());
		Collections.sort(b);
		b.forEach((v) -> System.out.println(v));

	}

	@Override
	public void searchMostExpensiveBook() {

//		searching the most expensive book 
//		which price is high
		books.values().stream()
		.max((o1,o2) -> Double.compare(o1.getPrice(),o2.getPrice()))
		.ifPresent(book -> System.out.println("Most Expensive book "+book));
		

	}

	@Override
	public void removeAllNotAvailableBook() {
//			remove all not available books where status is false
//		books.forEach((k, v ) -> System.out.println(k+" "+v));
		books.entrySet().removeIf(book ->  !book.getValue().isAvailableStock());
	}

	@Override
	public String updateBookPrice(int bookId,double price) {
//		get the id 
		Book b = books.get(bookId);
		b.setPrice(price);
		return "Updation successfull";
	}

	@Override
	public void sortBookBypriceAsc() {
		List<Book> b = new ArrayList<>(books.values());
		b.stream().sorted((o1,o2) -> Double.compare(o1.getPrice(),o2.getPrice()))
		.forEach(p -> System.out.println(p));

	}

}
