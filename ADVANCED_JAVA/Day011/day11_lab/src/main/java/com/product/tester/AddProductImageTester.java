package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;
import com.product.entities.Category;
import com.product.entities.Product;

public class AddProductImageTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {

			ProductDao dao = new ProductDaoImpl();

			System.out.println("product id and image path");
			Long userId = sc.nextLong();
			String filePath = sc.nextLine();
			System.out.println("Product image Added: " + dao.uploadImage(userId, filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
