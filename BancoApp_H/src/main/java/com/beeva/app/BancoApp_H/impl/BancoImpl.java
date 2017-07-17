package com.beeva.app.bancoapp_h.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.bancoapp_h.dao.BancoDAO;
import com.beeva.app.bancoapp_h.modelo.Banco;
import com.beeva.app.bancoapp_h.utilidades.MongoUtil;

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
	public List<Banco> getAllBanco() {
		try {
		      Query query = manager.createQuery("from Banco");
		      @SuppressWarnings("unchecked")
			List<Banco> list=query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
