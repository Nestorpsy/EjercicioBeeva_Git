package com.beeva.app.bancoapp_h.dao;

import java.util.List;

import com.beeva.app.bancoapp_h.modelo.TipoDeCuenta;

public abstract class TipoDeCuentaDAO {
	public abstract TipoDeCuenta getTipoDeCuenta(TipoDeCuenta tipoDeCuenta);
	public abstract List<TipoDeCuenta>  getAllTipoDeCuenta();
}
