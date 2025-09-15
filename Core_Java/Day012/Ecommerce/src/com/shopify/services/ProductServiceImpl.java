package com.shopify.services;

import java.util.ArrayList;
import java.util.List;

import com.shopify.core.Category;
import com.shopify.core.Product;
import com.shopify.exceptions.ECommerceException;
import com.shopify.exceptions.DuplicateResourceException;

public class ProductServiceImpl implements ProductService {

	private List<Product> products;

	public ProductServiceImpl() {
		this.products = new ArrayList<>();
		products.add(new Product("Apple iPhone 15", Category.ELECTRONICS, 79999.99, 10));
		products.add(new Product("Zara tshirts", Category.CLOTHING, 5999.50, 0));
		products.add(new Product("Samsung Refrigerator", Category.ELECTRONICS, 45999.00, 5));
		products.add(new Product("The Alchemist Book", Category.BOOKS, 499.00, 0));

	}

	public static void validateProduct(String name, Category category, List<Product> products)
			throws DuplicateResourceException {

//		call the equals method which check the content not reference for that need to override equals method in product class
//		but equals method expects object so need to add the constructor to initialize with only productId

		for (Product product : products) {

			if (product.getProductName().equalsIgnoreCase(name) && product.getProductCategory() == category) {
				throw new DuplicateResourceException("Duplicate products not allowed");
			}
		}

	}

	@Override
	public String addProduct(String name, String category, double price, int stock) throws DuplicateResourceException {
//				we need to check the same category and product category is exist if yes 
//		throws exception
//		validate the Category type
		Category validCategory = Category.valueOf(category.toUpperCase());
		validateProduct(name, validCategory, products);

//		after checking just add the list
		products.add(new Product(name, validCategory, price, stock));
		
		return "Product Added Successfully";

	}

	@Override
	public void DisplayProduct() {

		for (Product pd : products) {
			System.out.println(pd);
		}

	}

	@Override
	public void DisplayProductWithStockStatus() {
		for (Product pd : products) {
			String status = (pd.getProductStock() > 0) ? "In Stock" : "Out of Stock";
			System.out.println(pd + " | Status: " + status);

		}
	}

	@Override
	public Product findProductById(int productId) throws ECommerceException {

		int index = products.indexOf(new Product(productId));
		
		if (index == -1) {
			throw new ECommerceException("Product not found ");
		}
		Product prd = products.get(index);

		return prd;
	}

//	get products

}
