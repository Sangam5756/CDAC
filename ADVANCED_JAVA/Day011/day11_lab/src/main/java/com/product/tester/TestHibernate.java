package com.product.tester;

import static com.product.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		try (SessionFactory factory = getFactory()) {
			System.out.println("hibernate up n running , SF " + factory);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
