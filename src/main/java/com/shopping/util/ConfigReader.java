package com.shopping.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop; 
	
	public Properties init_prop() throws FileNotFoundException {
		
		prop= new Properties();
		
		FileInputStream ip= new FileInputStream("./src/test/resources/configurations/config.properties");
		try {
			prop.load(ip);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	
	

}
