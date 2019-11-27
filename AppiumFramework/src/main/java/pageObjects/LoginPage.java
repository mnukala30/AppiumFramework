package pageObjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.android.AndroidDriver;
import practise.AppiumFramework.ConfigReader;
import practise.AppiumFramework.Utilities;

public class LoginPage {
	
	ConfigReader CR = new ConfigReader();
	AndroidDriver<WebElement> driver;
	Properties prop;
	FileInputStream fis;
	PropertiesParsing propertiesParser;
	
	public LoginPage(AndroidDriver<WebElement> driver) {
		this.driver=driver;
		propertiesParser=new PropertiesParsing();
		prop=propertiesParser.propertiesParser(System.getProperty("user.dir")+"/src/main/resources/login.properties");
		
	}
	
		
	public WebElement getUserNamePath() {
		return driver.findElements(By.xpath(prop.getProperty("username_path"))).get(1);
		}
	
	public WebElement getPasswordPath() {
		return driver.findElements(By.xpath(prop.getProperty("password_path"))).get(1);
	}
	
	public WebElement getloginBtnPath() {
		return driver.findElements(By.xpath(prop.getProperty("loginBtn_path"))).get(1);
	}
	
	public WebElement getsignUpNowPath() {
		return driver.findElements(By.xpath(prop.getProperty("signUpNow_path"))).get(1);
	}
	
	public WebElement getRememberMePath() {
		return driver.findElements(By.xpath(prop.getProperty("rememberMe_path"))).get(1);
	}
	
	public WebElement getForgotUserNamePath() {
		return driver.findElement(By.xpath(prop.getProperty("forgot_user_name")));
	}
	
	////////
	public WebElement getForgotFirstNamePath() {
		return driver.findElement(By.xpath(prop.getProperty("first_name_path")));
	}
	
	public WebElement getForgotLastNamePath() {
		return driver.findElement(By.xpath(prop.getProperty("last_name_path")));
	}
	public WebElement getForgotMemberIdPath() {
		return driver.findElement(By.xpath(prop.getProperty("member_id_path")));
	}
	public WebElement getForgotEmailPath() {
		return driver.findElement(By.xpath(prop.getProperty("email_path")));
	}
	public WebElement getForgotStatePath() {
		return driver.findElement(By.xpath(prop.getProperty("state_path")));
	}
	public WebElement selectStatePath() {
		return driver.findElement(By.xpath(prop.getProperty("click_state_florida")));
	}
	public WebElement getForgotDobpath() {
		return driver.findElement(By.xpath(prop.getProperty("date_of_birth_path")));
	}
	public WebElement getForgotMMpath() {
		return driver.findElements(By.xpath(prop.getProperty("month_dd_yyyy_path"))).get(0);
	}
	public WebElement getMMNegativeIconPathpath() {
		return driver.findElement(By.xpath(prop.getProperty("month_negative_icon_path")));
	}
	public WebElement getDateNegativeIconPathpath() {
		return driver.findElement(By.xpath(prop.getProperty("date_negative_icon_path")));
	}
	public WebElement getForgotDDpath() {
		return driver.findElements(By.xpath(prop.getProperty("month_dd_yyyy_path"))).get(1);
	}
	public WebElement getForgotYYYYpath() {
		return driver.findElements(By.xpath(prop.getProperty("month_dd_yyyy_path"))).get(2);
	}
	
	public WebElement getDobSetBtnPath() {
		return driver.findElement(By.xpath(prop.getProperty("set_path")));
	}
	public WebElement getForgotSubmitBtnPath() {
		return driver.findElement(By.xpath(prop.getProperty("submit_button_path")));
	}
	public WebElement getForgotCancelBtnPath() {
		return driver.findElement(By.xpath(prop.getProperty("cancel_button_path")));
	}
	
	
	//////
	public WebElement getForgotPasswordPath() {
		return driver.findElements(By.xpath(prop.getProperty("forgot_password"))).get(1);
	}
	
	/*
	 * Data retrieval methods(get) from properties file
	 * Last Modified: 11/15/2019
	 */
	public String getUserName() {
		return prop.getProperty("username");
	}
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	/*
	 * 
	 * Data for forgot username and forgot password
	 * 
	 */
	public String getFirstName() {
		return prop.getProperty("first_name");
	}
	public String getLastName() {
		return prop.getProperty("last_name");
	}
	
	public String getMemberId() {
		return prop.getProperty("member_id");
	}
	public String getState() {
		return prop.getProperty("state");
	}
	
	public String getDob() {
		return prop.getProperty("dob");
	}
	public String getMM(String dobType) {
		String DOB=null;
		if(dobType.equalsIgnoreCase("invalid"))
			
		{
		 DOB=prop.getProperty("invalid_dob");}
		else if(dobType.equalsIgnoreCase("valid"))
		{
			DOB=prop.getProperty("valid_dob");
		}
		String[]date=DOB.split("-");
		String MM=date[0];
		System.out.println(MM);
		return MM;
	}
	
	public String getDD(String dobType) {
				
		String DOB = null;
		if(dobType.equalsIgnoreCase("invalid"))
			
		{
		 DOB=prop.getProperty("invalid_dob");}
		else if(dobType.equalsIgnoreCase("valid"))
		{
			DOB=prop.getProperty("valid_dob");
		}
		String[]date=DOB.split("-");
		String DD=date[1];
		System.out.println(DD);
		return DD;
	}
	public String getYYYY(String dobType) {
		
		String DOB=null;
		if(dobType.equalsIgnoreCase("invalid"))
			
		{
		 DOB=prop.getProperty("invalid_dob");
		 }
		else if(dobType.equalsIgnoreCase("valid"))
		{
			DOB=prop.getProperty("valid_dob");
		}
		String[]date=DOB.split("-");
		String YYYY=date[2];
		System.out.println(YYYY);
		return YYYY;
	}
	
	public String getEmail() {
		return prop.getProperty("email");
	}
	
	public String getUsernameInForgot() {
		return prop.getProperty("forgot_username");
	}
	
	public String getPasswordInForgot() {
		return prop.getProperty("forgot_password");
	}
	
	public void loginToConvey() {
		
		getUserNamePath().sendKeys(CR.getUserName());
		getPasswordPath().sendKeys(CR.getPassword());
		getloginBtnPath().click();
	}
	
	public void forgotUsername(String dobType) throws InterruptedException {
		Utilities util=new Utilities(driver);		
		util.scrollAndClick("Forgot Username");
		getForgotFirstNamePath().sendKeys(getFirstName());
		getForgotLastNamePath().sendKeys(getLastName());
		getForgotMemberIdPath().sendKeys(getMemberId());
		getForgotEmailPath().sendKeys(getEmail());
		getForgotStatePath().click();
		
		util.scrollToText(getState());
		selectStatePath().click();
		setDate(dobType);
		getForgotSubmitBtnPath().click();
		
	}
	
	public void setDate(String dobType) {
		getForgotDobpath().click();
				
		if(dobType.equalsIgnoreCase("invalid")) {
			System.out.println("Setting up Incorrect date of birth");
			getForgotYYYYpath().clear();
			getForgotYYYYpath().sendKeys(getYYYY(dobType));
			String mm=getMM(dobType);
			char mm1=mm.charAt(0);
			char mm2=mm.charAt(1);
			char mm3=mm.charAt(2);
			getForgotMMpath().sendKeys(mm1+"");
			getForgotMMpath().sendKeys(mm2+"");
			getForgotMMpath().sendKeys(mm3+"");
			//setMonth();
			if(getForgotMMpath().getText().contains(getMM(dobType))) {
				getForgotDDpath().clear();
				getForgotDDpath().sendKeys(getDD(dobType));
			}
			else
			{
				System.out.println("Month is not enetered in the 1st iteration, reiterating the method");
				getForgotYYYYpath().clear();
				getForgotYYYYpath().sendKeys(getYYYY(dobType));
				getForgotMMpath().sendKeys(getMM(dobType));
				getForgotDDpath().clear();
				getForgotDDpath().sendKeys(getDD(dobType));
			}
			
		}
		else if(dobType.equalsIgnoreCase("valid")) 
		{
			System.out.println("Setting up correct date of birth");
			getForgotYYYYpath().clear();
			getForgotYYYYpath().sendKeys(getYYYY(dobType));
			getForgotMMpath().sendKeys(getMM(dobType));
			
			if(getForgotMMpath().getText().contains(getMM(dobType))) {
				getForgotDDpath().clear();
				getForgotDDpath().sendKeys(getDD(dobType));
			}
			else
			{
				System.out.println("Month is not enetered in the 1st iteration, reiterating the method");
				getForgotYYYYpath().clear();
				getForgotYYYYpath().sendKeys(getYYYY(dobType));
				getForgotMMpath().sendKeys(getMM(dobType));
				
				if(getForgotMMpath().getText().contains(getMM(dobType))) {
					getForgotDDpath().clear();
					getForgotDDpath().sendKeys(getDD(dobType));
				}
				else
				{
					System.out.println("Month is not enetered in the 2nd iteration, reiterating the method");	
				getDobSetBtnPath().click();
				setDate(dobType);
				}
			}
			
		}
		
			
		
		getDobSetBtnPath().click();
	}



}
