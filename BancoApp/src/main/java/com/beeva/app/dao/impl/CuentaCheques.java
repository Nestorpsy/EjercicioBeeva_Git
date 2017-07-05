package com.beeva.app.dao.impl;

import com.beeva.app.dao.Cliente;
import com.beeva.app.dao.CuentaDAO;

public class CuentaCheques implements CuentaDAO{

	public boolean deposito(Cliente cliente, double dep) {
		
		return false;
	}

	public boolean retiro(Cliente cliente, double ret) {
		if(cliente.getCuenta().getBalance()<5000){
			
		}
		return false;
	}
}
