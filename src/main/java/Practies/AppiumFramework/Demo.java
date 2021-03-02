package Practies.AppiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Demo
{
	
	 AndroidDriver<AndroidElement> driver;
	public Utility(AndroidDriver<AndroidElement> drive)
	{
		this.driver=driver;
	}
	
	public  void scoll(String element)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element +"\"))"); 
	}

	public void LongPress (WebElement element) throws InterruptedException
	{
		TouchAction t=new TouchAction(driver);	
		t.longPress(longPressOptions().withElement(element(element)).withDuration(Duration.ofSeconds(5))).release().perform();
		Thread.sleep(50);
					
	}

	
}
