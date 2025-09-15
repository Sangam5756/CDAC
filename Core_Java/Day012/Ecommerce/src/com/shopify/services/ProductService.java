package com.shopify.services;

import com.shopify.core.Product;
import com.shopify.exceptions.ECommerceException;
import com.shopify.exceptions.DuplicateResourceException;

public interface ProductService {
//	first method to add the product
	public String addProduct(String name, String category, double price, int stock) throws DuplicateResourceException;

	public void DisplayProduct();


	public void DisplayProductWithStockStatus();

	Product findProductById(int product) throws ECommerceException;
}
