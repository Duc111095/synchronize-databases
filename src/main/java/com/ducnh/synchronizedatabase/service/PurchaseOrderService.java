package com.ducnh.synchronizedatabase.service;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ducnh.synchronizedatabase.entities.PurchaseOrder;
import com.ducnh.synchronizedatabase.utils.HibernateUtils;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PurchaseOrderService {
	public static void synchronizeData(final String dateFrom, final String dateTo, final String tmList, 
			final String nkList, final int userId, final String unit, final int admin) {	
		try (
			SessionFactory sessionMssqlFactory = HibernateUtils.getSessionFactory("hibernate-mssql.cfg.xml");
			SessionFactory sessionMysqlFactory = HibernateUtils.getSessionFactory("hibernate-mysql.cfg.xml");) 
		{
			Session sesMssql = sessionMysqlFactory.openSession();
			Session sesMysql = sessionMysqlFactory.openSession();
			
			Transaction tx = null;
		    
		    try {				
		    	log.info("Start Session Factory...");
			    tx = sesMysql.beginTransaction();

		    	Query query = sesMssql.createSQLQuery("CALL rpt_total_dhkd(:DateFrom, :DateTo, :tmList, :nkList, :ma_vt, :userId, :unit, :admin)")
						  .addEntity(PurchaseOrder.class)
						  .setParameter("DateFrom", dateFrom)
						  .setParameter("DateTo", dateTo)
						  .setParameter("tmList", tmList)
						  .setParameter("nkList", nkList)
						  .setParameter("userId", userId)
						  .setParameter("unit", unit)
						  .setParameter("admin", admin);
				
				@SuppressWarnings("unchecked")
				List<PurchaseOrder> puOrders = query.getResultList();
				
				for (PurchaseOrder po : puOrders) {
					sesMysql.persist(po);
				}
			
				log.info("Total Orders: {}", puOrders.size());
			    tx.commit();
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
