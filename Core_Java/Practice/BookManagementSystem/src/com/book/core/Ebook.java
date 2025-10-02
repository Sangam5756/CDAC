package com.book.core;

public class Ebook extends Book {
	double filesize;
	BookFormat format;

	public Ebook(String title, String author, int rating, double price, boolean availableStock, BookType genre,
			double filesize, BookFormat format) {
		super(title, author, rating, price, availableStock, genre);
		this.filesize = filesize;
		this.format = format;
	}

	public double getFilesize() {
		return filesize;
	}

	public void setFilesize(double filesize) {
		this.filesize = filesize;
	}

	public BookFormat getFormat() {
		return format;
	}

	public void setFormat(BookFormat format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "Ebook [filesize=" + filesize + ", format=" + format + ", toString()=" + super.toString() + "]";
	}

	@Override
	public double calculateDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
