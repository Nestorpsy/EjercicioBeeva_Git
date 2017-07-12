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
			mongo.mandarLog(banco,"addBanco");
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
			return manager.find(Banco.class, idbanco);			
		} catch (Exception e) {
			System.out.println("BancoImpl.getBanco()");
			e.printStackTrace();
			return null;
		}finally {
			manager.clear();
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
		}finally {
			manager.clear();
		}
	}

}
