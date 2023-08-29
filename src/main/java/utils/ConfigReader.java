package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public static Properties initializeconfig() {
		
		Properties prop = new Properties();
		
		String path = System.getProperty("user.dir")+"//src//test//resources//config//Config.properties";
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(path);
			 prop.load(fis);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return prop;
		
	}
	
	
	
	
	
	
	

}
