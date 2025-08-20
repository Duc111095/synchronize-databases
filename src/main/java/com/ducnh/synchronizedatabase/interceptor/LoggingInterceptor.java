package com.ducnh.synchronizedatabase.interceptor;

import java.io.Serializable;
import java.util.Iterator;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoggingInterceptor extends EmptyInterceptor{
	
	private static final long serialVersionUID = -1038971864999840396L;

	@Override
	public String onPrepareStatement(String sql) {
		log.debug("onPrepareStatement: {}", sql);
		return super.onPrepareStatement(sql);
	}
	
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		log.debug("onSave: {}", entity);
		return super.onSave(entity, id, state, propertyNames, types);
	}
	
	@Override
	public void preFlush(@SuppressWarnings("rawtypes") Iterator entities) {
		log.debug("preFlush: {}", entities.next());
		super.preFlush(entities);
	}
	
	@Override
	public void postFlush(@SuppressWarnings("rawtypes") Iterator entities) {
		log.debug("postFlush: {}", entities.next());
		super.postFlush(entities);
	}
}
