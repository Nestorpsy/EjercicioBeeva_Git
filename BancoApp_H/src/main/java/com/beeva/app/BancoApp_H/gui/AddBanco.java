package com.beeva.app.BancoApp_H.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.beeva.app.BancoApp_H.impl.BancoImpl;
import com.beeva.app.BancoApp_H.modelo.Banco;
import com.beeva.app.BancoApp_H.utilidades.ContexSingle;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBanco extends JPanel {
	private JTextField textFieldNombreAddBanco;
	ContexSingle single = ContexSingle.getInstance();

	/**
	 * Create the panel.
	 */
	public AddBanco() {
		setLayout(null);
		
		JLabel lblNuevoBanco = new JLabel("Nuevo Banco");
		lblNuevoBanco.setBounds(171, 13, 82, 16);
		add(lblNuevoBanco);
		
		JLabel lblNombreAddBanco = new JLabel("Nombre del Banco: ");
		lblNombreAddBanco.setBounds(74, 99, 115, 16);
		add(lblNombreAddBanco);
		
		textFieldNombreAddBanco = new JTextField();
		textFieldNombreAddBanco.setBounds(208, 96, 162, 22);
		add(textFieldNombreAddBanco);
		
		JButton btnGuardarAddBanco = new JButton("Guardar");
		btnGuardarAddBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	Banco banco = new Banco();
		    	BancoImpl impl = (BancoImpl) single.getContext().getBean(BancoImpl.class);
		    	banco.setNombre(textFieldNombreAddBanco.getText());
		    	impl.addBanco(banco);
		    	textFieldNombreAddBanco.setText("");
			}
		});
		btnGuardarAddBanco.setBounds(171, 183, 97, 25);
		add(btnGuardarAddBanco);

	}
}
