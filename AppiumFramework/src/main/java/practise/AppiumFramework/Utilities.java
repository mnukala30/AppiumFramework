package practise.AppiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import  io.appium.java_client.touch.offset.PointOption;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities {
	AndroidDriver<WebElement>  driver;
	public TouchAction t;
	public Actions A;
	public Utilities(AndroidDriver<WebElement> driver)
	{
		this.driver=driver;
	}

	
	public void scrollToText(String text)
	{
	     driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void scrollAndClick(String visibleText) {
	     driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
	        }
	    
	public void performSingleTap(WebElement obj) {
		t= new TouchAction<>(driver);
		t.tap(tapOptions().withElement(element(obj))).perform();
	}
	
	public void performSingleTapByAxis(int x, int y) {
		t= new TouchAction<>(driver);
		PointOption point=new PointOption();
		t.tap(PointOption.point(x,y)).perform(); 
	}
	public void clickOnElementByPointCoOrdinates(MobileElement element) {
		t= new TouchAction<>(driver);
		t.press(new PointOption<ElementOption>().withCoordinates(element.getCenter())).release().perform();
		}
	public void performPress(WebElement ele) {
		t=new AndroidTouchAction(driver);
		t.press(ElementOption.element(ele)).
		waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).release().perform();
	}
	public void performLongPress(WebElement ele) {
		t=new TouchAction<>(driver);
		t.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release().perform();
	}
	public void performSwipe(WebElement ele1, WebElement ele2) {
		t=new TouchAction<>(driver);
		t.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(2)))
		.moveTo(element(ele2)).release().perform();
	}
	public void performDragDrop(WebElement ele1, WebElement ele2) {
		t=new TouchAction<>(driver);
		 t.longPress(element(ele1)).moveTo(element(ele2)).release().perform();
		
	}
	public void performClickOn(WebElement ele) {
		ele.click();
	}
	public void performDoubleClick(WebElement ele) {
		A= new Actions(driver);
		A.doubleClick(ele).perform();
	}
	public void performRightClick(WebElement ele) {
		A= new Actions(driver);
		A.contextClick(ele).perform();
	}
	public void performMoveToElement(WebElement ele) {
		A= new Actions(driver);
		A.moveToElement(ele).perform();
	}
	public void getScreenshot(String s) throws IOException
	{
	File scrfile=	((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scrfile,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	
	}
	public Set<String> getAllContexts() {
		Set<String> contexts=driver.getContextHandles();
		return contexts;
	}
	public void switchContext(String contextName) {
		driver.context(contextName);
		
	}
	public Set<String> getWindowHandles() {
		Set<String> windowHandles=driver.getWindowHandles();
		return windowHandles;
	}
	public String getCurrentWindowHandle() {
		String windowHandle=driver.getWindowHandle();
		return windowHandle;
	}
	public void switchToWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	public void getListByTagName(String tagName) {
		List<WebElement>list= new ArrayList<>();
		list=driver.findElementsByTagName(tagName);
		
	}
}
