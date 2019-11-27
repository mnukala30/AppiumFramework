package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import practise.AppiumFramework.ConfigReader;
import practise.AppiumFramework.Utilities;

public class HomePage {

	ConfigReader CR = new ConfigReader();
	AndroidDriver<WebElement> driver;
	Properties prop;
	FileInputStream fis;
	PropertiesParsing propertiesParser;
	
	public HomePage(AndroidDriver<WebElement> driver) {
		this.driver=driver;
		propertiesParser=new PropertiesParsing();
		prop=propertiesParser.propertiesParser(System.getProperty("user.dir")+"/src/main/resources/homepage.properties");
		
	}
	
	
	public WebElement getNavBarIconPath() {
		return driver.findElement(By.xpath(prop.getProperty("navigation_bar_icon")));
	}
	
	public WebElement getSearchboxPath() {
		return driver.findElement(By.xpath(prop.getProperty("search_path")));
	}
	public WebElement getshop_by_category_icon() {
		return driver.findElement(By.xpath(prop.getProperty("shop_by_category_icon")));
	}
	public String getCatalongNumber() {
		return prop.getProperty("catalog_number");
	}
	
	public String getProductToShop() {
		return prop.getProperty("product_to_shop");
	}
	public void selectItemFromCategory() {
	
		Point point = getNavBarIconPath().getLocation();
		int xcord = point.getX();
		 System.out.println("Position of the webelement from left side is "+xcord +" pixels");
		 int ycord = point.getY();
		 System.out.println("Position of the webelement from top side is "+ycord +" pixels");
		 xcord=xcord+36;
		 Utilities util= new Utilities(driver);
		 util.performSingleTapByAxis(xcord,ycord);
		 
		if(getshop_by_category_icon().isDisplayed()) {
			getshop_by_category_icon().click();}
	
	}
	
	/*
	 * 
	 * This method is used to search the products with catalog number/product name
	 * Creation Date: 11/15/2019
	 */
	
	public void searchByCatalogNum() {
		getSearchboxPath().sendKeys(getCatalongNumber());	
	}
	
	public void searchByProductName() {
		getSearchboxPath().sendKeys(getProductToShop());	
	}
}

