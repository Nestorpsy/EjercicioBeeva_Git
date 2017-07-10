package com.beeva.app.pruevaJPA.dao;

import com.beeva.app.pruevaJPA.modelo.Usuario;


public abstract class UsuariosDAO {
	public abstract void  save(Usuario usuarios);
	public abstract Usuario getrUser(int id);
}
