package com.beeva.app.bancoapp_h.dao;

import com.beeva.app.bancoapp_h.modelo.Cuenta;

public interface CuentaTipoDAO {
	public Cuenta deposito(Cuenta cuenta,double dep);
	public Cuenta retiro(Cuenta cuenta,double ret);	
}
