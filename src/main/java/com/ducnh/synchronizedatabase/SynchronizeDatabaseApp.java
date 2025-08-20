package com.ducnh.synchronizedatabase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ducnh.synchronizedatabase.entities.Tag;
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
		try (SessionFactory sessionFactory = HibernateUtils.getSessionFactory()) {
			Session session = sessionFactory.openSession();
			
			log.info("Statistics enabled = " + sessionFactory.getStatistics());
			
			session.beginTransaction();
			
			final int numberOfRecords = 30;
			final int batchSize = 10;
			for (int i = 1; i <= numberOfRecords; i++) {
				Tag tag = new Tag();
				tag.setName("Hibernate Batch Processing " + i);
				session.persist(tag);
				
				if (i % batchSize == 0 && i != numberOfRecords) {
					log.info("Flush a batch of Insert & release memory: {} time(s)", (i/batchSize));
					session.flush();
					session.clear();
				}
			}
			log.info("Flush the last time at commit time");
			 
            session.getTransaction().commit();
		}
	}
}
