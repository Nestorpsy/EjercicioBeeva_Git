package com.beeva.app.BancoApp_H.dao;

import com.beeva.app.BancoApp_H.modelo.Cuenta;

public abstract class CuentaDAO {
	public abstract void addCuenta(Cuenta cuenta);
	public abstract Cuenta getCuenta(int idcuenta);
	public abstract void updateCuenta(Cuenta cuenta);
}
