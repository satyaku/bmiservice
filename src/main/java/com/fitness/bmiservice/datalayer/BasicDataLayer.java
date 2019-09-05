package com.fitness.bmiservice.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDataLayer {
	
	Connection connection;

	public Connection getConnection() throws SQLException{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/try", "root", "root");
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
