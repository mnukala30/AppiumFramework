package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import practise.AppiumFramework.ConfigReader;

public class CheckOutPage {

	ConfigReader CR = new ConfigReader();
	AndroidDriver<WebElement> driver;
	Properties prop;
	FileInputStream fis;
	PropertiesParsing propertiesParser;
	
	public CheckOutPage(AndroidDriver<WebElement> driver) {
		this.driver=driver;
		propertiesParser=new PropertiesParsing();
		prop=propertiesParser.propertiesParser(System.getProperty("user.dir")+"/src/main/resources/chekout.properties");
		
	}
	public WebElement getContinueShoppingPath() {
		return driver.findElement(By.xpath(prop.getProperty("continue_shopping")));
	}
	public WebElement getConfirmOrderPath() {
		return driver.findElement(By.xpath(prop.getProperty("confirm_order")));
	}
	
	public void clickContinueShopping() {
		
		if(getContinueShoppingPath().isDisplayed())
		getContinueShoppingPath().click();
		
	}
}
