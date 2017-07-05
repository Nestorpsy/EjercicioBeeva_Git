package com.beeva.app.dao;

public class Cliente {
	private String nombre;
	private String apellido;
	private Cuenta cuenta;
	
	public Cliente(String nombre, String apellido, Cuenta cuenta) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cuenta = cuenta;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

}
