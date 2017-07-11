package com.beeva.app.mongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("contex-core.xml");    
        try {        	    	        	
            MongoClient mongo = (MongoClient) context.getBean("mydataSource");
			DB db = mongo.getDB("testdb");
			DBCollection table = db.getCollection("user");
			
			BasicDBObject document = new BasicDBObject();
			document.put("nombre", "Juan");
			document.put("edad", "29");
			table.insert(document);
		}catch (Exception e) {
			e.printStackTrace();
		}
    }
}
