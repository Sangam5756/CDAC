package com.healthcare.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory factory;
	static {
		System.out.println("in static block");
		factory=new Configuration()
				.configure() //hibernate loads the props & mappings from cfg file in config class
				.buildSessionFactory();
	}
	//getter 
	public static SessionFactory getFactory() {
		return factory;
	}
	

}
