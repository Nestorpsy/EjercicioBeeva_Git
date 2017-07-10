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
		manager.persist(usuarios);
	}

	@Override
	@Transactional
	public Usuario getrUser(int id) {		
		return manager.find(Usuario.class,id);
	}
}
