package com.beeva.app.bancoapp_h.dao;

import java.util.List;

import com.beeva.app.bancoapp_h.modelo.Cliente;

public abstract class ClienteDAO {
	public abstract void addCiente(Cliente cliente);
	public abstract Cliente getCliente(int idcliente);
	public abstract void updateCliente(Cliente cliente);
	public abstract List<Cliente>  getAllCliente();
}
