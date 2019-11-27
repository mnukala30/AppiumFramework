package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import practise.AppiumFramework.ConfigReader;

public class CategoriesPage {

	ConfigReader CR = new ConfigReader();
	AndroidDriver<WebElement> driver;
	Properties prop;
	FileInputStream fis;
	PropertiesParsing propertiesParser;
	
	public CategoriesPage(AndroidDriver<WebElement> driver) {
		this.driver=driver;
		propertiesParser=new PropertiesParsing();
		prop=propertiesParser.propertiesParser(System.getProperty("user.dir")+"/src/main/resources/categories.properties");
		
	}
	
	public WebElement getAllergyPath() {
		return driver.findElement(By.xpath(prop.getProperty("allergy_cold")));
	}
	public WebElement getAntacidsPath() {
		return driver.findElement(By.xpath(prop.getProperty("antacids_acid")));
	}
	public WebElement getAntiDiarraheaPath() {
		return driver.findElement(By.xpath(prop.getProperty("anti_diarrahea")));
	}
	
	public WebElement getAntiFungalPath() {
		return driver.findElement(By.xpath(prop.getProperty("anti_fungal")));
	}
	
	public void selectCategory() {
		getAllergyPath().click();
	}
	
}
