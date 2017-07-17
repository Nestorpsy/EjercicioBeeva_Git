package com.beeva.app.bancoapp_h.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.beeva.app.bancoapp_h.dao.BancoDAO;
import com.beeva.app.bancoapp_h.dao.BancosClientesDAO;
import com.beeva.app.bancoapp_h.dao.ClienteDAO;
import com.beeva.app.bancoapp_h.dao.CuentaDAO;
import com.beeva.app.bancoapp_h.dao.TipoDeCuentaDAO;
import com.beeva.app.bancoapp_h.impl.BancoClientesImpl;
import com.beeva.app.bancoapp_h.impl.BancoImpl;
import com.beeva.app.bancoapp_h.impl.ClienteImpl;
import com.beeva.app.bancoapp_h.impl.CuentaImpl;
import com.beeva.app.bancoapp_h.impl.TipoDeCuentaImpl;
import com.beeva.app.bancoapp_h.modelo.Banco;
import com.beeva.app.bancoapp_h.modelo.BancosClientes;
import com.beeva.app.bancoapp_h.modelo.Cliente;
import com.beeva.app.bancoapp_h.modelo.Cuenta;
import com.beeva.app.bancoapp_h.modelo.TipoDeCuenta;
import com.beeva.app.bancoapp_h.utilidades.ContexSingle;
import com.beeva.app.bancoapp_h.utilidades.ComboBox;
public class AddCuenta extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	static String cliente;
	private JComboBox<String> comboBoxBanco;
	private JComboBox<String> comboBoxIDClienteAddCuenta;
	private JComboBox<String> comboBoxTipoCuenta;
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
		
		lblNewLabel = new JLabel("Cliente: ");
		lblNewLabel.setBounds(59, 120, 336, 16);
		add(lblNewLabel);
		
		JLabel lblTipoDeCuentaAddCuenta = new JLabel("Tipo de Cuenta ");
		lblTipoDeCuentaAddCuenta.setBounds(183, 187, 96, 16);
		add(lblTipoDeCuentaAddCuenta);
		
		JButton btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	ClienteDAO dao = (ClienteImpl) getContexIniciado().getContext().getBean(ClienteImpl.class);	
		    	String id = comboBoxIDClienteAddCuenta.getSelectedItem().toString();
		    	Cliente cliente = dao.getCliente(Integer.parseInt(id));	
		    	String datos;		    	
		    	datos = cliente.getNombre()+" "+cliente.getApellido();
				lblNewLabel.setText("Cliente: "+datos);
			}
		});
		
		btnConsultarCliente.setBounds(161, 149, 153, 25);
		add(btnConsultarCliente);
		
		JButton btnGuardarAddCuenta = new JButton("Crear");
		btnGuardarAddCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				String id = comboBoxIDClienteAddCuenta.getSelectedItem().toString();	
				int clienteId = Integer.parseInt(id);
				/*
				 * Se genera el id de Cuneta por Nombre 
				 */
				TipoDeCuentaDAO tipoDeCuentaDAO = (TipoDeCuentaImpl) getContexIniciado().getContext().getBean(TipoDeCuentaImpl.class);
				int idTipocuenta = 0;				
				List<TipoDeCuenta> listTipoCuenta = tipoDeCuentaDAO.getAllTipoDeCuenta();				
				for (TipoDeCuenta e : listTipoCuenta) {					
					if(e.getNombre().equals(comboBoxTipoCuenta.getSelectedItem())){
						idTipocuenta= e.getIdtipocuenta();
					}					
				}	
				
				/*
				 * Se genera la Cuenta 
				 */		
				Cuenta cuenta = new Cuenta();
				cuenta.setBalance(0.0);
				cuenta.setIdcliente(clienteId);
				cuenta.setIdtipocuenta(idTipocuenta);				
				CuentaDAO cuentaDAO = (CuentaImpl) getContexIniciado().getContext().getBean(CuentaImpl.class);				
				cuentaDAO.addCuenta(cuenta);			
	
				/*
				 * Se genera id de Banco por nombre
				 */
				BancoDAO bancoDAO = (BancoImpl) getContexIniciado().getContext().getBean(BancoImpl.class);
				int idBanco=0;				
				List<Banco> list = bancoDAO.getAllBanco();
				for (Banco e : list) {
					if(e.getNombre().equals(comboBoxBanco.getSelectedItem())){
						idBanco= e.getIdbanco();
					}					
				}
				
				/**
				 * Se genra la relacion de banco y cliente
				 */				
				BancosClientes bancosClientes = new BancosClientes();	
				bancosClientes.setIdbanco(getComponentCount());
				bancosClientes.setIdbanco(idBanco);
				bancosClientes.setIdcliente(clienteId);
				BancosClientesDAO bancosClientesDAO = (BancoClientesImpl) getContexIniciado().getContext().getBean(BancoClientesImpl.class);
				bancosClientesDAO.addBancoClientes(bancosClientes);			
				comboBoxBanco.setSelectedIndex(0);		
				comboBoxIDClienteAddCuenta.setSelectedIndex(0);		
				comboBoxTipoCuenta.setSelectedIndex(0);		
			}
		});
		btnGuardarAddCuenta.setBounds(182, 246, 97, 25);
		add(btnGuardarAddCuenta);
		
		JLabel lblSelccioneBancoAddCuenta = new JLabel("Selccione Banco: ");
		lblSelccioneBancoAddCuenta.setBounds(108, 45, 118, 16);
		add(lblSelccioneBancoAddCuenta);
		
		comboBoxBanco = ComboBox.createJComboBoxBanco();		
		comboBoxBanco.setBounds(238, 42, 105, 22);
		add(comboBoxBanco);	
		
		comboBoxTipoCuenta = ComboBox.createJComboBoxTipoCuenta();
		comboBoxTipoCuenta.setBounds(150, 216, 154, 22);
		add(comboBoxTipoCuenta);
		
		comboBoxIDClienteAddCuenta = ComboBox.createJComboBoxCliente();
		comboBoxIDClienteAddCuenta.setBounds(249, 85, 58, 22);
		add(comboBoxIDClienteAddCuenta);
		comboBoxIDClienteAddCuenta.getSelectedItem();

	}	
	
	public ContexSingle getContexIniciado(){
		ContexSingle single = ContexSingle.getInstance();
		return single;
	}
}
