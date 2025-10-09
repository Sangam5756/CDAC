package com.phone.service;

import com.phone.exception.PhoneException;

public interface PhoneService {
	
	public void addMobile( String modelName, String brand, int rating, boolean inStock, String phoneType,
			double price)throws Exception,PhoneException;
	public void displayAllMobile() throws Exception,PhoneException;
	public void displayAllMobileSortedById() throws Exception,PhoneException;
	public void searchLeastExpensive() throws PhoneException,Exception;
	public void removeAllOutofStockPhone() throws Exception,PhoneException;
	public void updateMobilePriceByModelName(String modelName,Double price) throws Exception,PhoneException;
	public void displayAllMobileSortByPriceAscending() throws Exception,PhoneException;
	
	
	
}
