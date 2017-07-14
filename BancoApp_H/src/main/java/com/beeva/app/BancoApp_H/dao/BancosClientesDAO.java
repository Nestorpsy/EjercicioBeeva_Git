package com.beeva.app.BancoApp_H.dao;

import java.util.List;

import com.beeva.app.BancoApp_H.modelo.BancosClientes;

public abstract class BancosClientesDAO {
	public abstract void addBancoClientes(BancosClientes bancosClientes);
	public abstract BancosClientes getBancosClientes(int idbancosclientes);	
	public abstract List<BancosClientes>  getAllBancosClientes();
}
