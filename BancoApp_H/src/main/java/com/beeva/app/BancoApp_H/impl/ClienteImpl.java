package com.beeva.app.bancoapp_h.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.bancoapp_h.dao.ClienteDAO;
import com.beeva.app.bancoapp_h.modelo.Cliente;
import com.beeva.app.bancoapp_h.utilidades.MongoUtil;

@Repository
public class ClienteImpl extends ClienteDAO{
	Logger logger = LoggerFactory.getLogger(ClienteImpl.class);
	private static final String error = "Contex"; 
	@PersistenceContext
	EntityManager manager;
	MongoUtil mongo = new MongoUtil();
	@Override
	@Transactional
	public void addCiente(Cliente cliente) {		
		try {
			manager.persist(cliente);
			mongo.mandarLog(cliente, "addCiente");
		} catch (Exception e) {
			logger.error("ClienteImpl.addCiente()");
			logger.debug(error, e);
			}
	}

	@Override
	@Transactional
	public Cliente getCliente(int idcliente) {		
		try {
			return manager.find(Cliente.class, idcliente);
		} catch (Exception e) {
			logger.error("ClienteImpl.getCliente()");
			logger.debug(error, e);			
			throw new RuntimeException();
		}
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		try {			
			manager.merge(cliente);
			mongo.mandarLog(cliente, "updateCliente");
		} catch (Exception e) {
			logger.error("ClienteImpl.updateCliente()");
			logger.debug(error, e);
		}
	}

	@Override
	@Transactional
	public List<Cliente> getAllCliente() {
		try {
		      Query query = manager.createQuery("from Cliente");
		      @SuppressWarnings("unchecked")
			List<Cliente> list=query.getResultList();
			return list;
		} catch (Exception e) {
			logger.error("ClienteImpl.getAllCliente()"+e);
			logger.debug(error, e);
			throw new RuntimeException();
		}
	}
}
