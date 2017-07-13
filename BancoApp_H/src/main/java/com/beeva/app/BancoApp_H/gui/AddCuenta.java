package com.beeva.app.BancoApp_H.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.beeva.app.BancoApp_H.dao.ClienteDAO;
import com.beeva.app.BancoApp_H.impl.BancoImpl;
import com.beeva.app.BancoApp_H.impl.ClienteImpl;
import com.beeva.app.BancoApp_H.impl.CuentaImpl;
import com.beeva.app.BancoApp_H.modelo.Cliente;
import com.beeva.app.BancoApp_H.modelo.Cuenta;
import com.beeva.app.BancoApp_H.utilidades.ContexSingle;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class AddCuenta extends JPanel {
	private JTextField textFieldNumeroDeClienteAddCuenta;
	private JLabel lblNewLabel;
	static String cliente;
	ContexSingle single = ContexSingle.getInstance();
	/**
	 * Create the panel.
	 */
	public AddCuenta() {		
		setLayout(null);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta");
		lblNuevaCuenta.setBounds(187, 13, 92, 16);
		add(lblNuevaCuenta);
		
		JLabel lblNumeroDeClienteAddCuenta = new JLabel("Numero de cliente: ");
		lblNumeroDeClienteAddCuenta.setBounds(119, 85, 118, 22);
		add(lblNumeroDeClienteAddCuenta);
		
		textFieldNumeroDeClienteAddCuenta = new JTextField();
		textFieldNumeroDeClienteAddCuenta.setBounds(251, 85, 74, 22);
		add(textFieldNumeroDeClienteAddCuenta);
		textFieldNumeroDeClienteAddCuenta.setColumns(10);
		
		lblNewLabel = new JLabel("Cliente: ");
		lblNewLabel.setBounds(59, 120, 336, 16);
		add(lblNewLabel);
		
		JLabel lblTipoDeCuentaAddCuenta = new JLabel("Tipo de Cuenta ");
		lblTipoDeCuentaAddCuenta.setBounds(183, 187, 96, 16);
		add(lblTipoDeCuentaAddCuenta);
		
		JRadioButton rdbtnAhorrosAddCuenta = new JRadioButton("Ahorros");
		rdbtnAhorrosAddCuenta.setBounds(130, 212, 74, 25);
		add(rdbtnAhorrosAddCuenta);
		
		JRadioButton rdbtnCheques = new JRadioButton("Cheques");
		rdbtnCheques.setBounds(264, 212, 92, 25);
		add(rdbtnCheques);
		
		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteImpl impl = new ClienteImpl();
				String idCuenta = textFieldNumeroDeClienteAddCuenta.getText();
				Cliente clienteDatos = impl.getCliente(Integer.parseInt(idCuenta));
				cliente = clienteDatos.getNombre()+" "+clienteDatos.getApellido();
				lblNewLabel.setText("Cliente: "+cliente);
			}
		});
		btnConsultarCliente.setBounds(161, 149, 153, 25);
		add(btnConsultarCliente);
		
		JButton btnGuardarAddCuenta = new JButton("Crear");
		btnGuardarAddCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardarAddCuenta.setBounds(182, 246, 97, 25);
		add(btnGuardarAddCuenta);
		
		JLabel lblSelccioneBancoAddCuenta = new JLabel("Selccione Banco: ");
		lblSelccioneBancoAddCuenta.setBounds(108, 45, 118, 16);
		add(lblSelccioneBancoAddCuenta);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(238, 42, 105, 22);
		add(comboBox);

	}
}
