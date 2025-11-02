package com.healthcare.listeners;

import com.healthcare.utils.HibernateUtils;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


/**
 * Application Lifecycle Listener implementation class HibernateSFManager
 *
 */
@WebListener
public class HibernateSFManager implements ServletContextListener {

    

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	 System.out.println("in ctx destroyed");
         HibernateUtils.getFactory().close();//SF : close , DBCP cleaned up !
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("in ctx inited");
         HibernateUtils.getFactory();//static init block : hib up n running
    }
	
}
