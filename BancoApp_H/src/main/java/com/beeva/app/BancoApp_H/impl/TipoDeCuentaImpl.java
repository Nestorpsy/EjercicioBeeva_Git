package com.beeva.app.BancoApp_H.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.TipoDeCuentaDAO;
import com.beeva.app.BancoApp_H.modelo.TipoDeCuenta;

@Repository
public class TipoDeCuentaImpl extends TipoDeCuentaDAO{
	@PersistenceContext
	EntityManager manager;
	
	@Override
	@Transactional
	public TipoDeCuenta getTipoDeCuenta(TipoDeCuenta tipoDeCuenta) {
		try {
			return manager.find(TipoDeCuenta.class, tipoDeCuenta);
		} catch (Exception e) {
			System.out.println("TipoDeCuentaImpl.getTipoDeCuenta()");
			e.printStackTrace();
			return null;
		}
	}

}
