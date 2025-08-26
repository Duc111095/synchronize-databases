package com.ducnh.synchronizedatabase.service;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ducnh.synchronizedatabase.utils.HibernateUtils;
import java.util.List;
import com.ducnh.synchronizedatabase.entities.*;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PurchaseOrderService {
	public static void synchronizeData(final String dateFrom, final String dateTo, final String tmList, final String nkList, 
			final String maVt, final int userId, final String unit, final int admin) {	
		try (
			SessionFactory sessionMssqlFactory = HibernateUtils.getSessionFactory("hibernate-mssql.cfg.xml");
			SessionFactory sessionMysqlFactory = HibernateUtils.getSessionFactory("hibernate-mysql.cfg.xml");) 
		{
			Session sesMssql = sessionMssqlFactory.openSession();
			Session sesMysql = sessionMysqlFactory.openSession();
			
			Transaction tx = null;
		    
		    try {
		    	Long startTime = System.currentTimeMillis();
		    	
			    tx = sesMysql.beginTransaction();
			    	
		    	Query query = sesMssql.createSQLQuery("exec rpt_total_dhkd :DateFrom, :DateTo, :tmList, :nkList, :maVt, :userId, :unit, :admin")
						  .addEntity(PurchaseOrder.class)
		    			  .setParameter("DateFrom", dateFrom)
						  .setParameter("DateTo", dateTo)
						  .setParameter("tmList", tmList)
						  .setParameter("nkList", nkList)
						  .setParameter("maVt", maVt)
						  .setParameter("userId", userId)
						  .setParameter("unit", unit)
						  .setParameter("admin", admin);
		    	
				@SuppressWarnings("unchecked")
				List<PurchaseOrder> results = query.getResultList();
				
				final int numberOfRecords = results.size();
				final int batchSize = 1000;
				query = sesMysql.createQuery("delete from PurchaseOrder");
				query.executeUpdate();
				
				for (int i = 0; i < numberOfRecords; i++) {
					PurchaseOrder po = results.get(i);
					sesMysql.save(po);
					
					if (i % batchSize == 0 && i != numberOfRecords) {
						log.info("Flush a batch of INSERT & release memory: {} time(s)", (i / batchSize));
						sesMysql.flush();
						sesMysql.clear();
					}
				}
			    tx.commit();
			    Long endTime = System.currentTimeMillis();
				log.info("Total processing: " + results.size());
				log.info("Total processed time: " + (endTime - startTime) + " ms");
			}
			catch (Exception e) {
			    if (tx != null ) tx.rollback();
			    throw e;
		    }
			finally {
				sesMssql.close();
				sesMysql.close();
			}
		}
	}
}
