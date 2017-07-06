package com.beeva.app.dao.factory;

import com.beeva.app.dao.Cuenta;
import com.beeva.app.dao.CuentaDAO;
import com.beeva.app.dao.impl.CuentaAhorro;
import com.beeva.app.dao.impl.CuentaCheques;

public class CuentaFactory{	
	
	private static final CuentaDAO cuentaConTipo = null;

	public CuentaDAO getImplCuenta(Cuenta cuenta){
		String tipoCuenta = cuenta.getTipoCuenta();
		if(tipoCuenta.equals("Cheques")){
			CuentaDAO cuentaConTipo = new CuentaAhorro();
			return cuentaConTipo;
		}
		if(tipoCuenta.equals("Ahorros")){
			CuentaDAO cuentaConTipo = new CuentaCheques();
			return cuentaConTipo;
		}
		return cuentaConTipo;
	}
}
