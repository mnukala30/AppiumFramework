package practise.AppiumFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import java.util.Properties;

/*
 * This class is used to read data given global.properties file
 * Owner : Atmecs.org
 * Version: 1.0
 * Last Changed Date: 14/11/2019
 */
public class ConfigReader {
	Properties prop;
	FileInputStream fis;
	public ConfigReader() {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\practise\\AppiumFramework\\global.properties");
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	//Methods to read data from properties file for Login existing users
	public String getUserName() {
		String uname= prop.getProperty("username");
		return uname;
	}
	
	/*public String getUserNamePath() {
		String uname= prop.getProperty("usernamePath");
		return uname;
	}*/
	public String getPassword() {
		String pwd= prop.getProperty("password");
		return pwd;
	}
	public String getUATurl() {
		return prop.getProperty("UATurl");
	}
	public String getDeviceName() {
		return prop.getProperty("deviceName");
	}
	public String getCategoryName() {
		return prop.getProperty("CategoryName");	}
	public String getProductName() {
		return prop.getProperty("productName");
	}
	
	//Method to read data from properties file for Sign up new users
	
	public String getFirstName() {
		return prop.getProperty("firstName");
	}
	
	public String getLastname() {
		return prop.getProperty("lastName");
	}
	
	public String getHealthPlanMemberId() {
		return prop.getProperty("healthPlanMemberId");
	}
	
	public String getState() {
		return prop.getProperty("state");
	}
	
	public String getDateOfBirth() {
		return prop.getProperty("dateOfBirth");
	}
	
	public String getEmail() {
		return prop.getProperty("email");
	}
	
	public String getConfirmEmail() {
		return prop.getProperty("confirmEmail");
	}
}
