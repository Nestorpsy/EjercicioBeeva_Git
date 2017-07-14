package com.beeva.app.BancoApp_H.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	@Transactional
	public List<TipoDeCuenta> getAllTipoDeCuenta() {
		try {
		      Query query = manager.createQuery("from TipoDeCuenta");
		      @SuppressWarnings("unchecked")
			List<TipoDeCuenta> list=query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
