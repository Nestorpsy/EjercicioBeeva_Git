package com.beeva.app.bancoapp_h.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.beeva.app.bancoapp_h.dao.ClienteDAO;
import com.beeva.app.bancoapp_h.impl.ClienteImpl;
import com.beeva.app.bancoapp_h.modelo.Cliente;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;

public class AddCliente extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldApellidoAddCliente;
	private JTextField textfieldNombreAddCliente;

	/**
	 * Create the panel.
	 */
	
	public AddCliente() {
		setLayout(null);
		setBorder(new EmptyBorder(15, 15, 15, 15));
		
		JLabel lblCliente = new JLabel("Nuevo Cliente");		
		lblCliente.setBounds(185, 13, 78, 16);
		add(lblCliente);
		
	    JLabel lblNombreAddCliente = new JLabel("Nombre: ");
	    lblNombreAddCliente.setBounds(73, 76, 67, 16); 	
	    add(lblNombreAddCliente);
	    
	    textfieldNombreAddCliente = new JTextField();
	    textfieldNombreAddCliente.setBounds(197, 73, 226, 22);
	    add(textfieldNombreAddCliente);
	    
	    JLabel lblApellidoAddCliente = new JLabel("Apellido: ");
        lblApellidoAddCliente.setBounds(73, 148, 56, 16);        
        add(lblApellidoAddCliente);  
        
        textFieldApellidoAddCliente = new JTextField();
        textFieldApellidoAddCliente.setBounds(197, 145, 226, 22);    	    
	    add(textFieldApellidoAddCliente);
        
        JButton btnAddCliente = new JButton("Guardar");
        btnAddCliente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Cliente cliente = new Cliente();
        		ClienteDAO dao = (ClienteImpl) getContexIniciado().getContext().getBean(ClienteImpl.class);
        		cliente.setNombre(textfieldNombreAddCliente.getText());
        		cliente.setApellido(textFieldApellidoAddCliente.getText());
        		dao.addCiente(cliente);
        		textfieldNombreAddCliente.setText("");
        		textFieldApellidoAddCliente.setText("");
        	}
        });
        btnAddCliente.setBounds(191, 228, 97, 25);
        add(btnAddCliente);
	}
	
	public ContexSingle getContexIniciado(){
		ContexSingle single = ContexSingle.getInstance();
		return single;
	}
}
