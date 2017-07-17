package com.beeva.app.bancoapp_h.factory;

import com.beeva.app.bancoapp_h.dao.CuentaTipoDAO;
import com.beeva.app.bancoapp_h.impl.CuentaAhorro;
import com.beeva.app.bancoapp_h.impl.CuentaCheques;
import com.beeva.app.bancoapp_h.modelo.Cuenta;

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
