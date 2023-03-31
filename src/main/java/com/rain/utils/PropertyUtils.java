package com.rain.utils;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

	static Properties properties=new Properties();
	static{
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Properties getProperties() {
		return properties;
	}
	
	
}
