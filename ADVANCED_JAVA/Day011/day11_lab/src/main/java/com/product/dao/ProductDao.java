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
	

}
