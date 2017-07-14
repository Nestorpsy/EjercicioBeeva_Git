package com.beeva.app.BancoApp_H.dao;

import java.util.List;

import com.beeva.app.BancoApp_H.modelo.TipoDeCuenta;

public abstract class TipoDeCuentaDAO {
	public abstract TipoDeCuenta getTipoDeCuenta(TipoDeCuenta tipoDeCuenta);
	public abstract List<TipoDeCuenta>  getAllTipoDeCuenta();
}
