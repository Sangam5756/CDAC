package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.User;

public class UserDaoImpl implements UserDao {
	@Override
	public User signIn(String email, String password) {
		User user=null;
		String jpql="select u from User u where u.email=:em and u.password =:pwd";
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
			// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class)
					.setParameter("em", email)
					.setParameter("pwd",password)
					.getSingleResult();
			//user - persistent
	
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return user;//user - detached
	}
	

}
