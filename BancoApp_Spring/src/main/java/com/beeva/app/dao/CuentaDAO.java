package com.beeva.app.dao;

public interface CuentaDAO {
	public boolean deposito(Cliente cliente,double dep);
	public boolean retiro(Cliente cliente,double ret);	
}
