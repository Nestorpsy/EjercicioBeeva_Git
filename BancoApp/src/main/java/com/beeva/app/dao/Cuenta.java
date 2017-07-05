package com.beeva.app.dao;

public class Cuenta {
	protected double balance;
	protected String tipoCuenta;
	
	public Cuenta(double balance, String tipoCuenta) {
		super();
		this.balance = balance;
		this.tipoCuenta = tipoCuenta;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
}
