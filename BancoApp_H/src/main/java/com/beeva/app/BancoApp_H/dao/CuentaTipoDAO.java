package com.beeva.app.BancoApp_H.dao;

import com.beeva.app.BancoApp_H.modelo.Cuenta;

public interface CuentaTipoDAO {
	public Cuenta deposito(Cuenta cuenta,double dep);
	public Cuenta retiro(Cuenta cuenta,double ret);	
}
