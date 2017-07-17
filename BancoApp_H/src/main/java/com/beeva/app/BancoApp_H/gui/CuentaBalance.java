package com.beeva.app.bancoapp_h.gui;

import com.beeva.app.bancoapp_h.dao.CuentaDAO;
import com.beeva.app.bancoapp_h.dao.CuentaTipoDAO;
import com.beeva.app.bancoapp_h.factory.CuentaFactory;
import com.beeva.app.bancoapp_h.impl.CuentaImpl;
import com.beeva.app.bancoapp_h.modelo.Cliente;
import com.beeva.app.bancoapp_h.modelo.Cuenta;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CuentaBalance extends JFrame {
	private static final long serialVersionUID = 1L;
	static ContexSingle single = ContexSingle.getInstance();
	JLabel lblBalance3;

	/**
	 * Create the panel.
	 */
	public CuentaBalance(Cliente cliente,final Cuenta cuenta) {
		getContentPane().setLayout(null);
		
		JLabel lblClienteConCuenta = new JLabel("Cliente con Cuenta");
		lblClienteConCuenta.setBounds(161, 13, 117, 16);
		getContentPane().add(lblClienteConCuenta);
		
		JLabel lblNombreDeCliente = new JLabel("Nombre de Cliente: ");
		lblNombreDeCliente.setBounds(35, 58, 117, 16);
		getContentPane().add(lblNombreDeCliente);
		
		JLabel lblApellido = new JLabel("Apellido: ");
		lblApellido.setBounds(35, 87, 56, 16);
		getContentPane().add(lblApellido);
		
		JLabel lblNewLabel = new JLabel("Tipo de cuenta");
		lblNewLabel.setBounds(35, 118, 101, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel labelNombre = new JLabel(cliente.getNombre());
		labelNombre.setBounds(208, 58, 108, 16);
		getContentPane().add(labelNombre);
		
		JLabel lblApelli = new JLabel(cliente.getApellido());
		lblApelli.setBounds(218, 87, 101, 16);
		getContentPane().add(lblApelli);
		
		JLabel labelTipoCuenta = new JLabel(String.valueOf(cuenta.getIdcuenta()));
		labelTipoCuenta.setBounds(208, 118, 108, 16);
		getContentPane().add(labelTipoCuenta);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(59, 173, 56, 16);
		getContentPane().add(lblBalance);
		
		lblBalance3 = new JLabel(String.valueOf(cuenta.getBalance()));
		lblBalance3.setBounds(237, 173, 94, 16);
		getContentPane().add(lblBalance3);
		
		JButton btnNewButton = new JButton("Retirar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Double numero=Double.valueOf(JOptionPane.showInputDialog("Ingresar cantidad a retirar"));
				CuentaFactory factory =  new CuentaFactory();
				Cuenta cuentarRet = cuenta;
				CuentaTipoDAO tipoDAO = factory.getImplCuenta(cuentarRet);
				cuentarRet = tipoDAO.retiro(cuentarRet, numero);
				lblBalance3.setText(String.valueOf(cuentarRet.getBalance()));
				CuentaDAO cuentaDAO = (CuentaImpl) single.getContext().getBean(CuentaImpl.class);
				cuentaDAO.updateCuenta(cuenta);
			}
		});
		btnNewButton.setBounds(55, 213, 97, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Depositar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double numero=Double.valueOf(JOptionPane.showInputDialog("Ingresar cantidad a depositar"));
				CuentaFactory factory =  new CuentaFactory();
				Cuenta cuentarRet = cuenta;
				CuentaTipoDAO tipoDAO = factory.getImplCuenta(cuentarRet);
				cuentarRet = tipoDAO.deposito(cuentarRet, numero);
				lblBalance3.setText(String.valueOf(cuentarRet.getBalance()));
				CuentaDAO cuentaDAO = (CuentaImpl) single.getContext().getBean(CuentaImpl.class);
				cuentaDAO.updateCuenta(cuenta);
			}
		});
		btnNewButton_1.setBounds(234, 213, 97, 25);
		getContentPane().add(btnNewButton_1);
		
	}
}
