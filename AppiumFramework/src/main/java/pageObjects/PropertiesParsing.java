package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParsing {
	Properties prop;
	FileInputStream fis;
	public Properties propertiesParser(String path) {
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
		prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
	
}
