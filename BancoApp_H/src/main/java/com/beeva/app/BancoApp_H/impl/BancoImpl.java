package com.beeva.app.BancoApp_H.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.BancoDAO;
import com.beeva.app.BancoApp_H.modelo.Banco;
import com.beeva.app.BancoApp_H.utilidades.MongoUtil;

@Repository
public class BancoImpl extends BancoDAO{
	@PersistenceContext
	EntityManager manager;
	MongoUtil mongo = new MongoUtil();
	@Override
	@Transactional
	public void addBanco(Banco banco) {
		try {		
			manager.flush();
			manager.persist(banco);	
			mongo.mandarLog(banco,"addBanco");
		} catch (Exception e) {			
			System.out.println("BancoImpl.addBanco()");
			e.printStackTrace();
		}		
	}

	@Override
	@Transactional
	public Banco getBanco(int idbanco) {
		try {			
			return null;//manager.find(Banco.class, idbanco);			
		} catch (Exception e) {
			System.out.println("BancoImpl.getBanco()");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	@Transactional
	public void deletBanco(Banco banco) {
		try {							
			manager.remove(banco);
			mongo.mandarLog(banco,"deletBanco");
		} catch (Exception e) {
			System.out.println("BancoImpl.deletBanco()");	
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public String getAllBanco() {
		try {
			String todo= "";
			
		      Query query = manager.createQuery("Select UPPER(e.nombre) from Banco e");
		      List<String> list=query.getResultList();
		      for(String e:list)
		      {
		    	 todo=todo+" "+e+"\n";
		         System.out.println("Employee NAME :"+e);
		      }
			return todo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

}
