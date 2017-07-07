package com.beeva.app.utilerias;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtils {
	public Connection conexion() {
		Connection connection =null;    	
    	try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/prueba","root","root");		
			return connection;
		} catch (Exception e) {
			System.out.println("Error de conexion X_X");
			e.printStackTrace();
			return null;
		}
	}
}
