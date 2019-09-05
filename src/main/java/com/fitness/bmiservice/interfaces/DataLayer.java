package com.fitness.bmiservice.interfaces;

import java.sql.SQLException;

public interface DataLayer {
	
	public abstract void initialSetup() throws SQLException;
	public abstract void terminate() throws SQLException;

}
