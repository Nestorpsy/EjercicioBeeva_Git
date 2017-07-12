package com.beeva.app.BancoApp_H.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.CuentaDAO;
import com.beeva.app.BancoApp_H.modelo.Cuenta;
import com.beeva.app.BancoApp_H.utilidades.MongoUtil;

@Repository
public class CuentaImpl extends CuentaDAO{
	@PersistenceContext
	EntityManager manager;
	MongoUtil mongo = new MongoUtil();
	@Override
	@Transactional
	public void addCuenta(Cuenta cuenta) {
		try {
			manager.persist(cuenta);	
			mongo.mandarLog(cuenta, "addCuenta");
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
			Cuenta cuentaActualizado = manager.find(Cuenta.class, cuenta.getIdcliente());
			cuentaActualizado.setBalance(cuenta.getBalance());
			mongo.mandarLog(cuentaActualizado, "addCuenta");
		} catch (Exception e) {
			System.out.println("CuentaImpl.updateCuenta()");
		}finally {
			manager.clear();
		}
	}	
}
