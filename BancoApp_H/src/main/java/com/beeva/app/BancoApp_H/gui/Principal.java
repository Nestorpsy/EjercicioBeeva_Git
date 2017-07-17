package com.beeva.app.bancoapp_h.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.beeva.app.bancoapp_h.utilidades.ContexSingle;

public class Principal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private AddBanco addBanco = new AddBanco();
	private AddCliente addCliente= new AddCliente();
	private AddCuenta addCuenta = new AddCuenta();
	private Cuentas cuentasPane = new Cuentas();
    static ContexSingle single = ContexSingle.getInstance();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Principal(JPanel contentPane) throws HeadlessException {
		super();
		this.contentPane = contentPane;
	}	
	
	public Principal() {	
		setTitle("BancoApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenu mnNuevo = new JMenu("Nuevo");
		mnOpciones.add(mnNuevo);
		
		JMenuItem mntmAddBanco = new JMenuItem("Banco");		
		mntmAddBanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJpanel(addBanco);
			}
		});
		
		mnNuevo.add(mntmAddBanco);
		
		JMenuItem mntmAddCliente = new JMenuItem("Cliente");
		mntmAddCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJpanel(addCliente);
			}
		});
		mnNuevo.add(mntmAddCliente);
		
		JMenuItem mntmAddCuenta = new JMenuItem("Cuenta");
		mntmAddCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJpanel(addCuenta);
			}
		});
		mnNuevo.add(mntmAddCuenta);
		
		JMenu mnAceder = new JMenu("Ingresar");
		mnOpciones.add(mnAceder);
		
		JMenuItem menuIngCuenta = new JMenuItem("Cuenta");
		mnAceder.add(menuIngCuenta);
		menuIngCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarJpanel(cuentasPane);
			}
		});
		cargarJpanelPrincipal();
	}
	
	protected void cargarJpanelPrincipal(){
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);		
		JLabel lblNewLabel = new JLabel("<html><center>Bienvenido!!<br>Seleciona una Opcion en menu Opciones.</center></html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
	}
	
	protected void cargarJpanel(JPanel panelNuevo) {
		contentPane.setVisible(false);		
		contentPane.removeAll();
		contentPane.add(panelNuevo,BorderLayout.CENTER,SwingConstants.CENTER);
		contentPane.setVisible(true);
		contentPane.repaint();
	}
	
	
}
