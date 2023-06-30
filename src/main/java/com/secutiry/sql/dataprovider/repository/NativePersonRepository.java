package com.secutiry.sql.dataprovider.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.secutiry.sql.dataprovider.entities.Person;

@Repository
public class NativePersonRepository {

	@Autowired
	private DataSource dataSource;
	
	public void deleteByName(String name) throws SQLException {
		String sql = "DELETE FROM person WHERE FIRST_NAME = '" + name + "';";
		
		Connection c = dataSource.getConnection();
	    c.createStatement().executeUpdate(sql);
	}
}