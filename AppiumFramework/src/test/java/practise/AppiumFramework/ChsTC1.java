package practise.AppiumFramework;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.model.Category;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CategoriesPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SignupPage;

public class ChsTC1 extends base{
	
	private AndroidDriver<WebElement> driver;
	LoginPage loginpage;
	HomePage homepage;
	CategoriesPage catPage;
	ProductPage productPage;
	CheckOutPage checkoutpage;
	ConfigReader CR;
	Utilities util;
	
	@BeforeClass
	public void launchCapabilities() throws IOException, InterruptedException {
		driver=capabilities();
		Thread.sleep(11000);
	}
	@Test(enabled=true)
	public void loginToApp() throws IOException, InterruptedException {
		
		loginpage= new LoginPage(driver);
		loginpage.loginToConvey();		
	}
	
	
	@Test(dependsOnMethods= {"loginToApp"},enabled=true)
	public void tc001_selectShopByCategory() throws InterruptedException {
	
		Thread.sleep(5000);
		homepage=new HomePage(driver);
		homepage.selectItemFromCategory();	
		catPage = new CategoriesPage(driver);
		catPage.selectCategory();
		productPage= new ProductPage(driver);
		productPage.chooseProduct();
		checkoutpage=new CheckOutPage(driver);
		checkoutpage.clickContinueShopping();
	}
	
	
	@Test(dependsOnMethods= {"loginToApp"},enabled=true)
	public void tc002_searchWithCatalogNumber() {
		homepage=new HomePage(driver);
		homepage.searchByCatalogNum();
		productPage= new ProductPage(driver);
		productPage.selectProductFromCatalogResults();
		checkoutpage=new CheckOutPage(driver);
		checkoutpage.clickContinueShopping();
	}
	
	@Test(dependsOnMethods= {"loginToApp"},enabled=true)
	public void tc003_searchWithProductName() {
		homepage=new HomePage(driver);
		homepage.searchByProductName();
		productPage= new ProductPage(driver);
		productPage.selectProductFromCatalogResults();
		checkoutpage=new CheckOutPage(driver);
		checkoutpage.clickContinueShopping();
	}
	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
}
