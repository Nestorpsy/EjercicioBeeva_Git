package com.beeva.app.BancoApp_H.impl;

import javax.swing.JOptionPane;

import com.beeva.app.BancoApp_H.dao.CuentaTipoDAO;
import com.beeva.app.BancoApp_H.modelo.Cuenta;
import com.beeva.app.BancoApp_H.utilidades.Validacion;

public class CuentaCheques implements CuentaTipoDAO{


	public Cuenta deposito(Cuenta cuenta, double dep) {
		boolean finalizado=false;
		dep=dep+cuenta.getBalance();
		cuenta.setBalance(dep);
		return cuenta;
	}

	public Cuenta retiro(Cuenta cuenta, double ret) {
		boolean finalizado=false;
		Validacion val = new Validacion();
		if(val.esDiaHabil()){
			ret=cuenta.getBalance()-ret;
			if(ret>=0){
				cuenta.setBalance(ret);
				finalizado=true;
			}
		}		
		if(finalizado==false){
			JOptionPane.showMessageDialog(null, "<html><center>El retino no se efectuo porque:"
					+ "<br>Es dia inhabil<br>Retiraste mas de lo que cuentas</center></html>",
					  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		return cuenta;
	}
}
