package com.beeva.app.BancoApp_H.impl;

import javax.swing.JOptionPane;

import org.springframework.transaction.annotation.Transactional;

import com.beeva.app.BancoApp_H.dao.CuentaTipoDAO;
import com.beeva.app.BancoApp_H.modelo.Cuenta;

public class CuentaAhorro implements CuentaTipoDAO{

	public Cuenta deposito(Cuenta cuenta, double dep) {		
		boolean finalizado=false;
		dep=dep+cuenta.getBalance();
		cuenta.setBalance(dep);
		return cuenta;
	}

	@Transactional
	public Cuenta retiro(Cuenta cuenta, double ret) {
		boolean finalizado=false;
		if(cuenta.getBalance()>=5000){
			ret=cuenta.getBalance()-ret;
			if(ret>=0){
				cuenta.setBalance(ret);
				finalizado=true;
			}			
		}
		if(finalizado==false){
			JOptionPane.showMessageDialog(null, "<html><center>El retino no se efectuo porque:"
					+ "<br>Su cuenta tiene menos de 5000<br>Retiraste mas de lo que cuentas</center></html>",
					  "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
		}
		return cuenta;
	}

}
