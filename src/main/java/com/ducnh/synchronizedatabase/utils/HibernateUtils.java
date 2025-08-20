package com.ducnh.synchronizedatabase.utils;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;

import com.ducnh.synchronizedatabase.interceptor.LoggingInterceptor;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	private HibernateUtils() {
		super();
	}
	
	private static SessionFactory buildSessionFactory() {
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.configure()
				.build();
		Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
		return metadata.getSessionFactoryBuilder()
				.applyInterceptor(new LoggingInterceptor())
				.build();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void close() {
		getSessionFactory().close();
	}
}
