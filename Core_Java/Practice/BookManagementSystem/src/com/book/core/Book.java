package com.book.core;

public abstract class Book implements Comparable<Book> {

	private int bookId;
	private String title, author;
	private int rating;
	private double price;
	private boolean availableStock;
	private BookType genre;
	public static int bookidCounter;
	static {
		bookidCounter = 1;
	}

	public Book(String title, String author, int rating, double price, boolean availableStock, BookType genre) {
		this.bookId = bookidCounter++;
		this.title = title;
		this.author = author;
		this.rating = rating;
		this.price = price;
		this.availableStock = availableStock;
		this.genre = genre;
	}

	public String getTitle() {
		return title;
	}

	public int getBookid() {
		return bookId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailableStock() {
		return availableStock;
	}

	public void setAvailableStock(boolean availableStock) {
		this.availableStock = availableStock;
	}

	public BookType getGenre() {
		return genre;
	}

	public void setGenre(BookType genre) {
		this.genre = genre;
	}

	public abstract double calculateDiscount();

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", rating=" + rating + ", price="
				+ price + ", availableStock=" + availableStock + ", genre=" + genre + "]";
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(bookId);
	}

	@Override
	public boolean equals(Object obj) {
//		first check the instance its of type book
		if (obj instanceof Book) {
//			downcast to book
			Book b = (Book) obj;
			return this.bookId == b.bookId;
		}
		return false;

	}
	@Override
	public int compareTo(Book o) {
		return Integer.compare(this.bookId, o.bookId);
	}

}
