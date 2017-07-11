package com.beeva.app.BancoApp_H.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
			manager.persist(banco);	
			
			
		} catch (Exception e) {			
			System.out.println("BancoImpl.addBanco()");
			e.printStackTrace();
		}finally {			
			manager.clear();
		}		
	}

	@Override
	@Transactional
	public Banco getBanco(int idbanco) {
		try {
			manager.getTransaction().begin();			
			return manager.find(Banco.class, idbanco);			
		} catch (Exception e) {
			System.out.println("BancoImpl.getBanco()");
			return null;
		}finally {
			manager.clear();
		}
		
	}

	@Override
	@Transactional
	public void deletBanco(Banco banco) {
		try {						
			manager.getTransaction().begin();	
			manager.remove(banco);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("BancoImpl.deletBanco()");			
		}finally {
			manager.clear();
		}
	}

}
