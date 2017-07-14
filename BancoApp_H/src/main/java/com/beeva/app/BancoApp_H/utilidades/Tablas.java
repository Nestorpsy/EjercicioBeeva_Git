package com.beeva.app.BancoApp_H.utilidades;
import java.util.List;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.beeva.app.BancoApp_H.dao.CuentaDAO;
import com.beeva.app.BancoApp_H.impl.ClienteImpl;
import com.beeva.app.BancoApp_H.impl.CuentaImpl;
import com.beeva.app.BancoApp_H.modelo.Cuenta;

public final class Tablas {
	static ContexSingle single = ContexSingle.getInstance();
	/**
	 * @wbp.factory
	 */
	public static JTable createJTable() {		
		DefaultTableModel modelo = new DefaultTableModel(){
			@Override
			public boolean isCellEditable (int row, int column){
				return false;
			}
		};		
		JTable tabla = new JTable (modelo);		
	
		modelo.addColumn("ID Cuenta");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellido");
		modelo.addColumn("Tipo de Cuenta");
		String fila[]= new String[4];
		fila[0]="ID-Cuenta";
		fila[1]="ID-Cliente";
		fila[2]="ID-TipoCuneta";
		fila[3]="Balance";
		modelo.addRow(fila);
		CuentaDAO cuentaDAO = (CuentaImpl)  single.getContext().getBean(CuentaImpl.class);
		List<Cuenta> cuentas = cuentaDAO.getAllCuenta();
		for(Cuenta cuenta :  cuentas){
			System.out.println(cuenta.toString());
			fila[0]= String.valueOf(cuenta.getIdcuenta());
			fila[1]= String.valueOf(cuenta.getIdcliente()); 
			fila[2]= String.valueOf(cuenta.getIdtipocuenta()); 
			fila[3]= String.valueOf(cuenta.getBalance()); 
			modelo.addRow(fila);
		}
		System.out.println("Tabala llenado");
		//modelo.addRow(cuentas.iterator());
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);		
		tabla.setModel(modelo);		
		return tabla;
	}
}