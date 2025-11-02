package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User signIn(String email, String pwd) {
		User user=null;
		String jpql="select u from User u where u.email=:em and u.password=:pass";
			// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. begin tx
		Transaction tx = session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class)
					.setParameter("em", email)
					.setParameter("pass", pwd)
					.uniqueResult();
			tx.commit();
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return user;
	}

	
	


		@Override
	public List<User> listUsers() {
		List<User> users = null;
		
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return users;
	}

	
}
