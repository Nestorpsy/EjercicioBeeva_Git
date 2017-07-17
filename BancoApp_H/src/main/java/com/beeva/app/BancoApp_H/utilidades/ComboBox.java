package com.beeva.app.bancoapp_h.utilidades;
import java.util.List;

import javax.swing.JComboBox;

import com.beeva.app.bancoapp_h.dao.BancoDAO;
import com.beeva.app.bancoapp_h.dao.ClienteDAO;
import com.beeva.app.bancoapp_h.dao.TipoDeCuentaDAO;
import com.beeva.app.bancoapp_h.impl.BancoImpl;
import com.beeva.app.bancoapp_h.impl.ClienteImpl;
import com.beeva.app.bancoapp_h.impl.TipoDeCuentaImpl;
import com.beeva.app.bancoapp_h.modelo.Banco;
import com.beeva.app.bancoapp_h.modelo.Cliente;
import com.beeva.app.bancoapp_h.modelo.TipoDeCuenta;

public final class ComboBox {
	static ContexSingle single = ContexSingle.getInstance();
	/**
	 * @wbp.factory
	 */
	public static JComboBox createJComboBox() {
		JComboBox comboBox = new JComboBox<String>();
		return comboBox;
	}
	
	public static JComboBox createJComboBoxBanco() {
		JComboBox comboBox = new JComboBox<String>();
		BancoDAO dao = (BancoImpl) single.getContext().getBean(BancoImpl.class);
		comboBox.addItem("--  Banco  --");
		List<Banco> list = dao.getAllBanco();
		for (Banco e : list) {			
			comboBox.addItem(e.getNombre());
			
			//System.out.println("Employee NAME :" + e.getNombre());
		}
		return comboBox;
	}
	
	public static JComboBox createJComboBoxCliente() {
		JComboBox comboBox = new JComboBox<String>();
		ClienteDAO dao = (ClienteImpl) single.getContext().getBean(ClienteImpl.class);
		comboBox.addItem("--  Id Cliente  --");
		List<Cliente> list = dao.getAllCliente();
		for (Cliente e : list) {
			comboBox.addItem(e.getIdcliente());
			//System.out.println("Cliente NAME :" + e.getIdcliente());
		}
		return comboBox;
	}
	
	public static JComboBox createJComboBoxTipoCuenta() {
		JComboBox comboBox = new JComboBox<String>();
		TipoDeCuentaDAO dao = (TipoDeCuentaImpl) single.getContext().getBean(TipoDeCuentaImpl.class);
		comboBox.addItem("--  Tipo De Cuenta  --");
		List<TipoDeCuenta> list = dao.getAllTipoDeCuenta();
		for (TipoDeCuenta e : list) {
			comboBox.addItem(e.getNombre());
			//System.out.println("Cliente NAME :" + e.getNombre());
		}
		return comboBox;
	}
}