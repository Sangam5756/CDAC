package com.hashset.test;

import java.util.HashSet;

import com.hashset.core.Category;
import com.hashset.core.Product;

public class Test2 {

	public static void main(String[] args) {
		Product product1 = new Product(101, "Bread", Category.FOOD, 100, 50);
		Product product2 = new Product(10, "Biscuits", Category.FOOD, 100, 50);
		Product product3 = new Product(101, "Bread", Category.FOOD, 100, 50);
		Product product4 = new Product(10, "Sunflower Oil", Category.OIL, 100, 50);
		Product product5 = new Product(101, "Rice", Category.GRAINS, 100, 50);

		
		
		HashSet<Product> products = new HashSet<>();
		System.out.println(products.add(product1));
		System.out.println(products.add(product2));
		System.out.println(products.add(product3));
		System.out.println(products.add(product4));
		System.out.println(products.add(product5));
		System.out.println(products.size());

	}
}
