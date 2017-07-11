package com.beeva.app.BancoApp_H.dao;

import com.beeva.app.BancoApp_H.modelo.Banco;

public abstract class BancoDAO {
	public abstract void addBanco(Banco banco);
	public abstract Banco getBanco(int idbanco);
	public abstract void deletBanco(Banco banco);
}