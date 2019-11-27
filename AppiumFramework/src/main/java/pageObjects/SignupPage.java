package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import bsh.util.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import practise.AppiumFramework.ConfigReader;
import practise.AppiumFramework.Utilities;

public class SignupPage {

ConfigReader CR = new ConfigReader();
AndroidDriver<WebElement> driver;
	
	public SignupPage(AndroidDriver<WebElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]/\"\r\n" + 
			"			+ \"android.view.View[2]/android.view.View[3]/android.widget.Button[2]")
	public WebElement SignUpNowBtn;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='2']")
	public WebElement FirstName;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='3']")
	public WebElement Lastname;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='4']")
	public WebElement HealthPlanID;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@index='5' or @text='Select State *']")
	public WebElement State;
	
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@text='Maine']")
	public WebElement ChooseState;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@index='6' and resource-id='DOB']")
	public WebElement DateOfBirth;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@res")
	public WebElement DateOfBirth_MM;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@index='6' and resource-id='DOB']")
	public WebElement DateOfBirth_DD;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@index='6' and resource-id='DOB']")
	public WebElement DateOfBirth_YYYY;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='7']")
	public WebElement Email;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='8']")
	public WebElement ConfirmEmail;
	
	@AndroidFindBy(xpath="//android.widget.Button[@index='1' or @text='Next Step']")
	public WebElement NextStepBtn;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='OK']")
	public WebElement OkBtn;
	
	
	public void newUserSignUp() {
		
		SignUpNowBtn.click(); // In the login page
		FirstName.sendKeys(CR.getFirstName());
		Lastname.sendKeys(CR.getLastname());
		HealthPlanID.sendKeys(CR.getHealthPlanMemberId());
		State.click();
		Utilities util= new Utilities(driver);
		util.scrollToText(CR.getState());
		ChooseState.click();
		DateOfBirth.click();
		
		
	}
}
