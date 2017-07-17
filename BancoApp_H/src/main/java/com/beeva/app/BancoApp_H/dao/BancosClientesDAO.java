package com.beeva.app.bancoapp_h.dao;

import java.util.List;

import com.beeva.app.bancoapp_h.modelo.BancosClientes;

public abstract class BancosClientesDAO {
	public abstract void addBancoClientes(BancosClientes bancosClientes);
	public abstract BancosClientes getBancosClientes(int idbancosclientes);	
	public abstract List<BancosClientes>  getAllBancosClientes();
}
