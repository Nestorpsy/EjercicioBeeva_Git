package com.beeva.app.bancoapp_h.gui;

import javax.swing.JPanel;
import javax.swing.JTable;

import com.beeva.app.bancoapp_h.modelo.Cuenta;
import com.beeva.app.bancoapp_h.dao.ClienteDAO;
import com.beeva.app.bancoapp_h.dao.CuentaDAO;
import com.beeva.app.bancoapp_h.impl.ClienteImpl;
import com.beeva.app.bancoapp_h.impl.CuentaImpl;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;
import com.beeva.app.bancoapp_h.utilidades.Tablas;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cuentas extends JPanel {
	static ContexSingle single = ContexSingle.getInstance();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Cuentas() {
		setLayout(null);		
		table = null;
		table = Tablas.createJTable();
		table.setBounds(43, 32, 373, 149);
		add(table);
		
		JButton btnNewButton = new JButton("Actualizar ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actualizaTabla();
			}
		});
		btnNewButton.setBounds(51, 217, 97, 25);
		add(btnNewButton);
		
		JButton btnIngresa = new JButton("Ingresa");
		btnIngresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int numero=Integer.parseInt(JOptionPane.showInputDialog("Ingrese ID de Cuenta Para Ingresar"));
				CuentaDAO cuentaDAO = (CuentaImpl)  single.getContext().getBean(CuentaImpl.class);
				Cuenta cuenta = cuentaDAO.getCuenta(numero);
				ClienteDAO clienteDAO = (ClienteImpl) single.getContext().getBean(ClienteImpl.class);				
				CuentaBalance balance = new CuentaBalance(clienteDAO.getCliente(cuenta.getIdcliente()), cuenta);
				balance.setSize(600, 400);
				balance.setVisible(true);
			}
		});
		btnIngresa.setBounds(299, 217, 97, 25);
		add(btnIngresa);
	}
	
	public void actualizaTabla(){
		table.setVisible(false);
		table.removeAll();
		table = Tablas.createJTable();
		table.setBounds(43, 32, 373, 149);
		table.setVisible(true);
		add(table);	
	}
}
