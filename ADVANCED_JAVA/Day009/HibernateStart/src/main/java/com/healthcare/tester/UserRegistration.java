package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.UserDao;
import com.healthcare.dao.UserDaoImpl;
import com.healthcare.entities.User;
import com.healthcare.entities.UserRole;

public class UserRegistration {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in); SessionFactory sf = getFactory()) {
			//create user dao instance
			UserDao userDao=new UserDaoImpl();			
			System.out.println(
					"Enter User Details - String firstName, String lastName, String email, String password, String phone, LocalDate dob,Role role");
			User user = new User(sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), LocalDate.parse(sc.next()),
					UserRole.valueOf(sc.next().toUpperCase()));
		System.out.println("Reg status "+userDao.signUp(user));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
