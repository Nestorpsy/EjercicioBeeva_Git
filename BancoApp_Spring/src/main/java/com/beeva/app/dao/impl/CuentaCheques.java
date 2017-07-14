package com.beeva.app.dao.impl;

import com.beeva.app.dao.Cliente;
import com.beeva.app.dao.CuentaDAO;
import com.beeva.app.utilerias.Validacion;

public class CuentaCheques implements CuentaDAO{

	public boolean deposito(Cliente cliente, double dep) {
		boolean finalizado=false;
		cliente.getCuenta().setBalance(cliente.getCuenta().getBalance()+dep);		
		return finalizado;
	}

	public boolean retiro(Cliente cliente, double ret) {
		boolean finalizado=false;
		Validacion val = new Validacion();
		if(val.esDiaHabil()){
			cliente.getCuenta().setBalance(cliente.getCuenta().getBalance()-ret);
			finalizado=true;
		}
		return finalizado;
	}
}
