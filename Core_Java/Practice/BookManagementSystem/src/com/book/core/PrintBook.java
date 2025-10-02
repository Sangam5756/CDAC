package com.book.core;

public class PrintBook extends Book {
	int page;
	double weight ;
	public PrintBook(String title, String author, int rating, double price, boolean availableStock, BookType genre,int page,double weight
			) {
		super(title, author, rating, price, availableStock, genre);
		this.page =page;
		this.weight=weight;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "PrintBook [page=" + page + ", weight=" + weight + ", toString()=" + super.toString() + "]";
	}
	@Override
	public double calculateDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	

}
