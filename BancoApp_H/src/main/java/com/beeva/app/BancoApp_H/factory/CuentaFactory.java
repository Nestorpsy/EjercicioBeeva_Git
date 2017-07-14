package com.beeva.app.BancoApp_H.factory;

import com.beeva.app.BancoApp_H.dao.CuentaTipoDAO;
import com.beeva.app.BancoApp_H.impl.CuentaAhorro;
import com.beeva.app.BancoApp_H.impl.CuentaCheques;
import com.beeva.app.BancoApp_H.modelo.Cuenta;

public class CuentaFactory{	
	
	private static final CuentaTipoDAO cuentaConTipo = null;

	public CuentaTipoDAO getImplCuenta(Cuenta cuenta){
		int tipoCuenta = cuenta.getIdtipocuenta();
		if(tipoCuenta==1){
			CuentaTipoDAO cuentaConTipo = new CuentaAhorro();
			return cuentaConTipo;
		}
		if(tipoCuenta==2){
			CuentaTipoDAO cuentaConTipo = new CuentaCheques();
			return cuentaConTipo;
		}
		return cuentaConTipo;
	}
}
