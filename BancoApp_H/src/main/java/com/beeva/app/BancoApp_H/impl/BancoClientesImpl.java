package com.beeva.app.BancoApp_H.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.BancosClientesDAO;
import com.beeva.app.BancoApp_H.modelo.BancosClientes;
import com.beeva.app.BancoApp_H.utilidades.MongoUtil;

@Repository
public class BancoClientesImpl extends BancosClientesDAO{
	@PersistenceContext
	EntityManager manager;
	MongoUtil mongo = new MongoUtil();	
	@Override
	@Transactional
	public void addBancoClientes(BancosClientes bancosClientes) {
		try {						
			manager.persist(bancosClientes);
			mongo.mandarLog(bancosClientes, "addBancoClientes");
		} catch (Exception e) {
			System.out.println("BancoClientesImpl.addBancoClientes()");		
			e.printStackTrace();
		}		
	}

	@Override
	@Transactional
	public BancosClientes getBancosClientes(int idbancosclientes) {
		try {
			return manager.find(BancosClientes.class, idbancosclientes);			
		} catch (Exception e) {
			System.out.println("BancoClientesImpl.getBancosClientes()");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public List<BancosClientes> getAllBancosClientes() {
		try {
		      Query query = manager.createQuery("from BancosClientes");
		      @SuppressWarnings("unchecked")
			List<BancosClientes> list=query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
