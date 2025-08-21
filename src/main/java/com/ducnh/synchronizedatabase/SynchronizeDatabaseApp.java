package com.ducnh.synchronizedatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ducnh.synchronizedatabase.entities.Category;
import com.ducnh.synchronizedatabase.utils.HibernateUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SynchronizeDatabaseApp {
	
	/**
	 * Synchronize from MSSQL to MySQL
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory("hibernate-mssql.cfg.xml")) {
			Session session = sessionFactory.openSession();
			
			log.info("Statistics enabled = " + sessionFactory.getStatistics());
			
			// Begin a unit of work
			session.beginTransaction();
			
			// Insert user
			Category cat = new Category();
			cat.setName("cat " + System.currentTimeMillis());
			log.info("Cat id =" + session.save(cat));

            session.getTransaction().commit();
			log.info("Statistics enabled = " + sessionFactory.getStatistics());

		}
	}
}
