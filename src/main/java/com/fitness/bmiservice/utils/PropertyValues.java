package com.fitness.bmiservice.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class PropertyValues {

	Properties properties = null;
	InputStream inputStream = null;
	
	public Properties getPropertyValues(String propFileName) throws IOException {
		
		try {
			properties = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			System.out.println("Properties fetched on "+time);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return properties;
	}

}
