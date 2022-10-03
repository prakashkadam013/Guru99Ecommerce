package Guru99_Demo_Ecommerce_Project_Magneto_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {

	public static Properties prop;
	
	public ConfigDataProvider(String filepath) {
		
		try {
			FileInputStream fins = new FileInputStream(filepath);
			prop = new Properties();
			prop.load(fins);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getemail() {
		return prop.getProperty("email");
	}
	
	public String getpassword() {
		return prop.getProperty("password");
	}
}
