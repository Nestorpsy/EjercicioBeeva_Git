package com.beeva.app.BancoApp_H.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.BancosClientesDAO;
import com.beeva.app.BancoApp_H.modelo.BancosClientes;

@Repository
public class BancoClientesImpl extends BancosClientesDAO{
	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	@Transactional
	public void addBancoClientes(BancosClientes bancosClientes) {
		try {
			manager.getTransaction().begin();
			manager.persist(bancosClientes);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("BancoClientesImpl.addBancoClientes()");			
		}finally {
			manager.clear();
		}		
	}

	@Override
	@Transactional
	public BancosClientes getBancosClientes(int idbancosclientes) {
		try {
			manager.getTransaction().begin();
			return manager.find(BancosClientes.class, idbancosclientes);
		} catch (Exception e) {
			System.out.println("BancoClientesImpl.getBancosClientes()");
			return null;
		}finally {
			manager.clear();
		}
	}

}
