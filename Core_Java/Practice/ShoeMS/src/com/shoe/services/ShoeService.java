package com.shoe.services;

import com.shoe.core.ShoeType;
import com.shoe.exception.ShoeException;

public interface ShoeService {

	public void addShoes(int shoeId, int ratings, String name, String brand, double price, boolean available,
			ShoeType shoetype) throws ShoeException;
	public void displayAllShoes();
	public void displayAllShoeSortByid();
	public void searchShoeById(int id) throws ShoeException;
	public void removeNotAvailableShoe() throws ShoeException;
	public void updateShoePrice(int id,double price) throws ShoeException;
	public void sortShoeDescByPrice();
	
	
}
