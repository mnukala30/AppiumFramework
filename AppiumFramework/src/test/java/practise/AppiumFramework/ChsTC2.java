package practise.AppiumFramework;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pageObjects.CategoriesPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SignupPage;

public class ChsTC2 extends base{

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
	
	@Test(priority=1,enabled=false)
	public void forgotUserNameInvalidDetails() throws InterruptedException {
		loginpage= new LoginPage(driver);
		loginpage.forgotUsername("invalid");
	}
	
	@Test(priority=1,enabled=true)
	public void forgotUserNameValidDetails() throws InterruptedException {
		loginpage= new LoginPage(driver);
		loginpage.forgotUsername("valid");
	}
	
	@Test(enabled=false)
	public void newUserSignUp() {
		util= new Utilities(driver);
		SignupPage signupPage= new SignupPage(driver);
		signupPage.newUserSignUp();
	}
	
	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/
}
