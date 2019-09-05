package com.fitness.bmiservice.datalayer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.fitness.bmiservice.constants.FileNameConstants;
import com.fitness.bmiservice.utils.PropertyValues;

public class BasicDataLayer {
	
	Connection connection = null;
	Properties configProperties = null;
	
	public BasicDataLayer(){
		try {
			configProperties = (new PropertyValues()).getPropertyValues(FileNameConstants.FILE_NAME_CONFIG_PROPERTIES);
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException{
		
		String dbUrl = configProperties.getProperty("dbConnUrl");
		String user = configProperties.getProperty("user");
		String password = configProperties.getProperty("password");
		String systemClass = configProperties.getProperty("systemClass");
		
		try {
			Class.forName(systemClass);
			connection = DriverManager.getConnection(dbUrl, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}
		
		return connection;
	}
	
	
	public void close(Connection conn){
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
