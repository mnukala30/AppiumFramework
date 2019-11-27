package pageObjects;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import practise.AppiumFramework.ConfigReader;

public class ProductPage {
	
	ConfigReader CR = new ConfigReader();
	AndroidDriver<WebElement> driver;
	Properties prop;
	FileInputStream fis;
	PropertiesParsing propertiesParser;
	
	public ProductPage(AndroidDriver<WebElement> driver) {
		this.driver=driver;
		propertiesParser=new PropertiesParsing();
		prop=propertiesParser.propertiesParser(System.getProperty("user.dir")+"/src/main/resources/product.properties");
		
	}
	public WebElement getProduct1Path() {
		return driver.findElement(By.xpath(prop.getProperty("product1")));
	}
	public WebElement getAdd_to_cart() {
		return driver.findElement(By.xpath(prop.getProperty("add_to_cart")));
	}
	
	public WebElement getView_in_cart() {
		return driver.findElement(By.xpath(prop.getProperty("view_in_cart")));
	}
	
	public WebElement getReview_your_order() {
		return driver.findElement(By.xpath(prop.getProperty("review_your_order")));
	}
	public WebElement getProceed_to_checkout() {
		return driver.findElement(By.xpath(prop.getProperty("proceed_to_checkout")));
	}
	public WebElement getCatalogTextPath() {
		return driver.findElement(By.xpath(prop.getProperty("catalog_product_path")));
	}
	
	public void chooseProduct() {
		getProduct1Path().click();
		getAdd_to_cart().click();
		getView_in_cart().click();
		getReview_your_order().click();
		getProceed_to_checkout().click();
	}
	public void selectProductFromCatalogResults() {
		getCatalogTextPath().click();
		getAdd_to_cart().click();
		getView_in_cart().click();
		getReview_your_order().click();
		getProceed_to_checkout().click();
	}
}
