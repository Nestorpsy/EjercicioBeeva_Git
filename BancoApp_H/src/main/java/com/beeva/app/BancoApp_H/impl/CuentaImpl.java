package com.beeva.app.BancoApp_H.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.CuentaDAO;
import com.beeva.app.BancoApp_H.modelo.Cuenta;

@Repository
public class CuentaImpl extends CuentaDAO{
	@PersistenceContext
	EntityManager manager;

	@Override
	@Transactional
	public void addCuenta(Cuenta cuenta) {
		try {
			manager.getTransaction().begin();
			manager.persist(cuenta);
			manager.getTransaction().commit();			
		} catch (Exception e) {
			System.out.println("CuentaImpl.addCuenta()");
		}finally {
			manager.clear();
		}
	}

	@Override
	@Transactional
	public Cuenta getCuenta(int idcuenta) {
		try {
			manager.getTransaction().begin();
			return manager.find(Cuenta.class, idcuenta);
		} catch (Exception e) {
			System.out.println("CuentaImpl.getCuenta()");
			return null;
		}finally {
			manager.clear();
		}
	}

	@Override
	@Transactional
	public void updateCuenta(Cuenta cuenta) {
		try {
			manager.getTransaction().begin();
			Cuenta cuentaActualizado = manager.find(Cuenta.class, cuenta.getIdcliente());
			cuentaActualizado.setBalance(cuenta.getBalance());
			manager.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("CuentaImpl.updateCuenta()");
		}finally {
			manager.clear();
		}
	}
	
}
