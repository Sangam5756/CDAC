package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.entities.Category;
import com.product.entities.Product;

public class AddProductTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {

			ProductDao dao = new ProductDaoImpl();

			System.out.println("Enter product details: category, mfd(yyyy-MM-dd), name, price, prod_desc, quantity");

			Category category = Category.valueOf(sc.next().toUpperCase());
			LocalDate mfd = LocalDate.parse(sc.next());
			String name = sc.next();
			double price = sc.nextDouble();
			String desc = sc.next();
			int qty = sc.nextInt();

			Product p = new Product(name, desc, mfd, qty, price, category);

			System.out.println("Added Product: " + dao.addProduct(p));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
