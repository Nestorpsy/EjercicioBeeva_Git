package com.beeva.app.pruevaJPA.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.pruevaJPA.dao.UsuariosDAO;
import com.beeva.app.pruevaJPA.modelo.Usuario;

@Repository
public class UsuariosImpl extends UsuariosDAO{
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void save(Usuario usuarios) {
		try {
			manager.getTransaction().begin();
			manager.persist(usuarios);
			manager.getTransaction().commit();			
		} catch (Exception e) {
			System.out.println("UsuariosImpl.save()");
		}finally {
			manager.clear();
		}
		
	}

	@Override
	@Transactional
	public Usuario getrUser(int id) {	
		try {
			manager.getTransaction().begin();
			return manager.find(Usuario.class,id);
		} catch (Exception e) {
			System.out.println("UsuariosImpl.getrUser()");
			return null;
		}finally {
			manager.clear();
		}
		
	}
}
