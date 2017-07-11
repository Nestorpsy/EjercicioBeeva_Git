package com.beeva.app.BancoApp_H.utilidades;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoUtil {
	
	private ApplicationContext context;

	public void mandarLog(Object todo){
		context = new ClassPathXmlApplicationContext("context-core.xml");    
	    try {        	    	        	
	        MongoClient mongo = (MongoClient) context.getBean("myMongo");
			DB db = mongo.getDB("testdb");
			DBCollection table = db.getCollection("logCollection");
			System.out.println(todo.toString());
			/*
			BasicDBObject document = new BasicDBObject();
			document.put("nombre", "Juan");
			document.put("edad", "29");
			table.insert(document);*/
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}
