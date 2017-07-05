package com.beeva.app.dao.impl;

import com.beeva.app.dao.Cliente;
import com.beeva.app.dao.CuentaDAO;

public class CuentaAhorro implements CuentaDAO{

	public boolean deposito(Cliente cliente, double dep) {
		System.out.println("CuentaAhorro");
		cliente.getCuenta().setBalance(cliente.getCuenta().getBalance()+dep);		
		return false;
	}

	public boolean retiro(Cliente cliente, double ret) {
		// TODO Auto-generated method stub
		return false;
	}

}
