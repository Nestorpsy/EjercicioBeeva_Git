package com.beeva.app.BancoApp_H.dao;

import com.beeva.app.BancoApp_H.modelo.BancosClientes;

public abstract class BancosClientesDAO {
	public abstract void addBancoClientes(BancosClientes bancosClientes);
	public abstract BancosClientes getBancosClientes(int idbancosclientes);	
}
