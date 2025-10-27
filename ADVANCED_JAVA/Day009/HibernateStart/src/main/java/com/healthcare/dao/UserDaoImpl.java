package com.healthcare.dao;

import com.healthcare.entities.User;
import static com.healthcare.utils.HibernateUtils.getFactory;
import org.hibernate.*;

public class UserDaoImpl implements UserDao {

	@Override
	public String signUp(User newUser) {
		// 1. Get Session from SessionFactory
		Session session=getFactory().getCurrentSession();
		//2. Begin a Transaction
		Transaction tx=session.beginTransaction();
		try {
			//3. Session API for inserting a record.
			session.persist(newUser);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
			{
				tx.rollback();//discard tx
			}
			throw e;
		}
		return "User registered successfully , with ID="+newUser.getId();
	}

}
