package com.beeva.batchdemo.job.fileProcessor.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class UserRowMapper implements RowMapper<User> {

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();

		
		user.setNombre(rs.getString("nombre"));
		user.setDireccion(rs.getString("direccion"));
		

		return user;
	}

}