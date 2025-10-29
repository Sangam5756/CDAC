package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.product.dao.ProductDao;
import com.product.dao.ProductDaoImpl;

public class ApplyDiscountTester {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {

			ProductDao dao = new ProductDaoImpl();

			System.out.println("Enter minimum quantity and discount percentage:");

			int minQty = sc.nextInt();
			double discountPercent = sc.nextDouble();

			String result = dao.addDiscount(minQty, discountPercent);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
