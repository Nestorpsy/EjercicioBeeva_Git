package com.beeva.app.bancoapp_h.dao;

import java.util.List;

import com.beeva.app.bancoapp_h.modelo.Banco;

public abstract class BancoDAO {
	public abstract void addBanco(Banco banco);
	public abstract Banco getBanco(int idbanco);
	public abstract void deletBanco(Banco banco);
	public abstract List<Banco>  getAllBanco();
}
