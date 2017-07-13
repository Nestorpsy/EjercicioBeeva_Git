package com.beeva.app.BancoApp_H.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.ClienteDAO;
import com.beeva.app.BancoApp_H.modelo.Cliente;
import com.beeva.app.BancoApp_H.utilidades.MongoUtil;

@Repository
public class ClienteImpl extends ClienteDAO{
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
			System.out.println("ClienteImpl.addCiente()");
			e.printStackTrace();
			}finally {
			manager.clear();
		}
	}

	@Override
	@Transactional
	public Cliente getCliente(int idcliente) {		
		try {			
			Cliente getcliente = new Cliente();
			getcliente=manager.find(Cliente.class,  idcliente);
			return getcliente;
		} catch (Exception e) {
			System.out.println("ClienteImpl.getCliente()");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		try {			
			Cliente clienteActualizado = manager.find(Cliente.class, cliente.getIdcliente());
			clienteActualizado.setNombre(cliente.getNombre());
			clienteActualizado.setApellido(cliente.getApellido());
			mongo.mandarLog(clienteActualizado, "updateCliente");
		} catch (Exception e) {
			System.out.println("ClienteImpl.updateCliente()");
			e.printStackTrace();
		}finally {
			manager.clear();
		}
	}

}
