package com.beeva.app.BancoApp_H.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.ClienteDAO;
import com.beeva.app.BancoApp_H.modelo.Cliente;

@Repository
public class ClienteImpl extends ClienteDAO{
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void addCiente(Cliente cliente) {	
		try {
			manager.getTransaction().begin();
			manager.persist(cliente);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("ClienteImpl.addCiente()");
		}finally {
			manager.clear();
		}
	}

	@Override
	@Transactional
	public Cliente getCliente(int idcliente) {
		try {
			manager.getTransaction().begin();
			return manager.find(Cliente.class, idcliente);
		} catch (Exception e) {
			System.out.println("ClienteImpl.getCliente()");
			return null;
		}finally {
			manager.clear();
		}		
	}

	@Override
	@Transactional
	public void updateCliente(Cliente cliente) {
		try {
			manager.getTransaction().begin();
			Cliente clienteActualizado = manager.find(Cliente.class, cliente.getIdcliente());
			clienteActualizado.setNombre(cliente.getNombre());
			clienteActualizado.setApellido(cliente.getApellido());
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("ClienteImpl.updateCliente()");
		}finally {
			manager.clear();
		}
	}

}
