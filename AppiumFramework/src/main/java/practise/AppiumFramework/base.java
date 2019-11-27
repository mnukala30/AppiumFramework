package practise.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	  public static AppiumDriverLocalService service;
	  public static AndroidDriver<WebElement>  driver;
	  public ConfigReader CR;
	  
	public AppiumDriverLocalService startServer()
	{
		//
	boolean flag=	checkIfServerIsRunnning(4723);
	if(!flag)
	{
		
		service=AppiumDriverLocalService.buildDefaultService();
		service.start();
	}
		return service;
		
	}
	
public static boolean checkIfServerIsRunnning(int port) {
		
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			
			serverSocket.close();
		} catch (IOException e) {
			//If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public  AndroidDriver<WebElement> capabilities() throws IOException, InterruptedException
	{
		
		CR= new ConfigReader();
	

		// TODO Auto-generated method stub
	   DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, CR.getDeviceName());
      //capabilities.setCapability(MobileCapabilityType.UDID,"ENU7N15C15003225");
      capabilities.setCapability(MobileCapabilityType.UDID,"f06a976f");
      capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
      capabilities.setCapability("appPackage","com.atmecs.xamarin.ConveyHealth");
      capabilities.setCapability("appActivity","md585af5f9a32c6a9ad7ad2b249cd8101f6.MainActivity");
      capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
      //capabilities.setCapability("chromedriverExecutableDir", "C:\\Users\\Mahesh.Nukala\\Downloads\\chromedriver_win32 (1)");
      // capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
      capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
      capabilities.setCapability(MobileCapabilityType.NO_RESET,"true");
     // noReset,true
     //capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,14);
     
     //capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
    driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    return driver;
	}
	
	public static void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
	
	

}
