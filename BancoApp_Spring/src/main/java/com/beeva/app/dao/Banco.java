package com.beeva.app.dao;


public class Banco {
	
	private Cliente [] clientes ;
	private int nClientes;
	
	public boolean addCliente(Cliente clientes){	
		this.clientes[getNClientes()]= clientes;
		nClientes++;
		return false;
	}


	public int getNClientes(){
		System.out.println(nClientes);
		return nClientes;
	}
	
	public Cliente getCliente(int nCliente){
		Cliente getcliente = clientes[nCliente];		
		return getcliente;
	}
}
