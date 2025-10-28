package com.product.dao;

import static com.product.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.product.entities.Category;
import com.product.entities.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public Product addProduct(Product product) throws HibernateException {
//		first need the current session
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

//		here take the new object
		try {

			session.persist(product);

//			now just commit the product
			tx.commit(); // here flush happen then clear cache the saved to db then close connection

		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;

		}

		return product;
	}

	@Override
	public Product displayProductById(int productId) throws HibernateException {
//		first need the current session
		Product product = null;
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

//		here take the new object
		try {

			product = session.find(Product.class, productId);

			System.out.println(product);
//			now just commit the product
			tx.commit(); // here flush happen then clear cache the saved to db then close connection

		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;

		}

		return product;
	}

	@Override
	public List<Product> displayProductByField(LocalDate date, Category category) throws HibernateException {
//		first need the current session
		List<Product> products = null;
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

//		here take the new object

		/*
		 * Display id , name , price of all the products manufactured before specified
		 * date and from specific category i/p - date , category(enum) o/p - List of
		 * selected products details
		 */
		try {
			String jpql = "select p.productId,p.name,p.price from Product p where p.mfd < :date and category=:ct";

			products = session.createQuery(jpql, Product.class).setParameter("date", date).setParameter("ct", category)
					.getResultList();

//			now just commit the product
			tx.commit(); // here flush happen then clear cache the saved to db then close connection

		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;

		}

		return products;
	}

	@Override
	public String changePriceByName(String pname, double price) throws HibernateException {

//		first need the current session
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

//		here take the new object
		try {

			String jpql = "select * from Product where name=:nm";
			Product product = session.createQuery(jpql, Product.class).setParameter("nm", pname).getSingleResult();
			product.setPrice(price);

//			now just commit the product
			tx.commit(); // here flush happen then clear cache the saved to db then close connection

		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;

		}

		return "product price updated";
	}

	@Override
	public String addDiscount(int qty, double discount) {
		String message = "No products updated!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {

//			 5. Apply discount to all products , whose available quantity > specified
//			 * quantity i/p - quantity n discount in % o/p - message
			String jpql = "update Product u set u.price = u.price - (u.price * :discount / 100) where u.quantity > :qt";
			int updateCount = session.createMutationQuery(jpql).setParameter("discount", discount)
					.setParameter("qt", qty).executeUpdate();

			tx.commit();
			message = "Discount applied successfully to " + updateCount + " product(s).";

		} catch (RuntimeException e) {

			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}

		return message;
	}

}
