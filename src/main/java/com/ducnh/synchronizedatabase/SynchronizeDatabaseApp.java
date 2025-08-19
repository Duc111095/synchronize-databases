package com.ducnh.synchronizedatabase;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class SynchronizeDatabaseApp {
	
	/**
	 * Synchronize from MSSQL to MySQL
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String... args) throws InterruptedException {
		final HazelcastInstance instance = Hazelcast.newHazelcastInstance();
		while (true) {
			Thread.sleep(1000);
		}
	}
}
