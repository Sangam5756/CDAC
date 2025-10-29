package com.product.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;

import com.product.entities.Category;
import com.product.entities.Product;

public interface ProductDao {

	public Product addProduct(Product product) throws HibernateException;

	public Product displayProductById(int productId) throws HibernateException;;

	public List<Product> displayProductByField(LocalDate date, Category category) throws HibernateException;;

	public String changePriceByName(String pname, double price) throws HibernateException;;

	public String addDiscount(int qty, double discount);

	public String uploadImage(Long userId, String filePath) throws IOException;

	public String restoreImage(String email,String path) throws IOException;
	/*
	 * 
	 * Solve as many as possible ( No Pressure !!!) 1. Add a new product i/p -
	 * product details (except id) o/p - message (success or failure)
	 * 
	 * 2. Display product details i/p - product id o/p - product details OR error
	 * message
	 * 
	 * 3. Display id , name , price of all the products manufactured before
	 * specified date and from specific category i/p - date , category(enum) o/p -
	 * List of selected products details
	 * 
	 * 4. Change Product price i/p - product name o/p - message
	 * 
	 * OPTIONAL
	 * 
	 * 5. Apply discount to all products , whose available quantity > specified
	 * quantity i/p - quantity n discount in % o/p - message
	 * 
	 * 
	 */

}
