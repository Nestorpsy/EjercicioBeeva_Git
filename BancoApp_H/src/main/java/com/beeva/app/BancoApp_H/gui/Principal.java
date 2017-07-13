package com.beeva.app.BancoApp_H.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.beeva.app.BancoApp_H.utilidades.ContexSingle;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private AddBanco addBanco = new AddBanco();
	private AddCliente addCliente= new AddCliente();
	private AddCuenta addCuenta = new AddCuenta();
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
				    single.setContext(new ClassPathXmlApplicationContext("context-core.xml"));
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
