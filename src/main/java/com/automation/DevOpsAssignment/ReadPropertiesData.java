package com.automation.DevOpsAssignment;

import java.io.FileReader;
import java.util.Properties;

public class ReadPropertiesData {
	String value = null;

	public String readPropertyValue(String property) throws Exception {
		FileReader reader = new FileReader("db.properties");

		Properties p = new Properties();
		p.load(reader);

		value = p.getProperty(property);
		
		return value;
	}

}
