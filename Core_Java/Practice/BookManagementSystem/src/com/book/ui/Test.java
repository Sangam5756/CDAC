package com.book.ui;

import com.book.service.BookServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		
		BookServiceImpl bookService = new BookServiceImpl();
		try {
			
			// Adding EBooks
			bookService.addEBook("Java Basics", "John Doe", 4, 300, true, "SCIENCE", 15, "PDF");
			bookService.addEBook("Advanced Java", "Jane Smith", 5, 450, true, "NONFICTION", 20, "TEXT");
			bookService.addEBook("Learning Spring", "Mike Ross", 3, 250, false, "SCIENCE", 10, "doc");

			// Adding PrintedBooks
			bookService.addPrintBook("Fictional Tales", "Emily Bronte", 5, 500, false, "FICTION", 320, 0.8);
			bookService.addPrintBook("History of Rome", "William Smith", 4, 600, true, "HISTORY", 400, 1.2);

			bookService.removeAllNotAvailableBook();
			bookService.displayAllBookSortedByid();
//			bookService.sortBookBypriceAsc();
			bookService.displayAllBook();
		}catch(Exception e) {
				System.out.println(e);
		}

	}

}
