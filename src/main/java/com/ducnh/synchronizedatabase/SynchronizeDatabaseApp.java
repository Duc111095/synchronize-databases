package com.ducnh.synchronizedatabase;

import com.ducnh.synchronizedatabase.service.PurchaseOrderService;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class SynchronizeDatabaseApp {
	
	/**
	 * Synchronize from MSSQL to MySQL
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		PurchaseOrderService.synchronizeData("20250101", "20251231", "", "", "", 2666, "", 1);
	}
}
