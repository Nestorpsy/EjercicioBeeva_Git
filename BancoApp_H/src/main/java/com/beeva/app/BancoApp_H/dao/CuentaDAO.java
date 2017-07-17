package com.beeva.app.bancoapp_h.dao;

import java.util.List;

import com.beeva.app.bancoapp_h.modelo.Cuenta;

public abstract class CuentaDAO {
	public abstract void addCuenta(Cuenta cuenta);
	public abstract Cuenta getCuenta(int idcuenta);
	public abstract void updateCuenta(Cuenta cuenta);
	public abstract List<Cuenta>  getAllCuenta();
}
