package com.beeva.app.bancoapp_h.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.bancoapp_h.dao.CuentaDAO;
import com.beeva.app.bancoapp_h.modelo.Cuenta;
import com.beeva.app.bancoapp_h.utilidades.MongoUtil;

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
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public Cuenta getCuenta(int idcuenta) {
		try {
			return manager.find(Cuenta.class, idcuenta);
		} catch (Exception e) {
			System.out.println("CuentaImpl.getCuenta()");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	@Transactional
	public void updateCuenta(Cuenta cuenta) {
		try {
			manager.merge(cuenta);
			mongo.mandarLog(cuenta, "updateCuenta");
		} catch (Exception e) {
			System.out.println("CuentaImpl.updateCuenta()");
			e.printStackTrace();
		}
	}

	@Override
	@Transactional
	public List<Cuenta> getAllCuenta() {
		try {
		      Query query = manager.createQuery("from Cuenta");
		      @SuppressWarnings("unchecked")
			List<Cuenta> list=query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
