package com.beeva.app.bancoapp_h.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.beeva.app.bancoapp_h.dao.BancoDAO;
import com.beeva.app.bancoapp_h.impl.BancoImpl;
import com.beeva.app.bancoapp_h.modelo.Banco;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;

public class AddBanco extends JPanel {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreAddBanco;
	
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
		    	BancoDAO dao = (BancoImpl) getContexIniciado().getContext().getBean(BancoImpl.class);
		    	banco.setNombre(textFieldNombreAddBanco.getText());
		    	dao.addBanco(banco);
		    	textFieldNombreAddBanco.setText("");
			}
		});
		btnGuardarAddBanco.setBounds(171, 183, 97, 25);
		add(btnGuardarAddBanco);

	}
	
	public ContexSingle getContexIniciado(){
		ContexSingle single = ContexSingle.getInstance();
		return single;
	}
}
