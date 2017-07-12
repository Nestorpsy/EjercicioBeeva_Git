package com.beeva.app.BancoApp_H.utilidades;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtil {
	
	private ApplicationContext context;

	public void mandarLog(Object todo,String accion){
		context = new ClassPathXmlApplicationContext("context-core.xml");    
	    try {        	    	        	
	        MongoClient mongo = (MongoClient) context.getBean("myMongo");
			DB db = mongo.getDB("testdb");
			DBCollection table = db.getCollection("logCollection");						
			BasicDBObject document = introspectInstance(todo, new PrintWriter(System.out),accion);
			table.insert(document);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static BasicDBObject introspectInstance(Object anObject, PrintWriter printer,String accion) throws IllegalArgumentException,  IllegalAccessException {
		BasicDBObject document = new BasicDBObject();
		document.put("Fecha", new Date());
		document.put("Accion", accion);
		@SuppressWarnings("rawtypes")
		Class objectType = anObject.getClass();
		document.put("Tabla", objectType.getSimpleName());		
		for (Field field : objectType.getDeclaredFields()) {
			field.setAccessible(true);
			String x = field.get(anObject).toString();
			document.put(field.getName(), x);
		}
		printer.flush();
		return document;
	}
	
}
