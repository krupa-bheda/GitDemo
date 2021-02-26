package Practies.AppiumFramework;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
//import java.net.MalformedURLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.compilers.Sj;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.util.concurrent.Service;

import Practies.AppiumFramework.ShoppingAppCap;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AmountCal extends ShoppingAppCap

{
	@Test
	public void Addition() throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		
	//services =startServer();
		executeCmd();
		 AndroidDriver<AndroidElement>  driver=ShoppingAppCap.Capability("GenralStoreApp");
		 PageObject pg=new PageObject(driver);
		 Utility ui=new Utility(driver);
		 driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		// driver.findElementByAndroidUIAutomator("text(\"Afghanistan\")").click();
		 pg.sel.click();
		 Thread.sleep(1000);
		 driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Antarctica\"))"); 
		 
		 String city="Antarctica";
		 //ui.scoll(city);	
		// driver.findElementByAndroidUIAutomator("text(\"Antarctica\")").click(); 
		 pg.clkAntarctica.click();
		// driver.findElementByAndroidUIAutomator("text(\"Enter name here\")").sendKeys("Krupa");
		 pg.inputName.sendKeys("Krupa");
		 driver.hideKeyboard();//to hide keyboard
		// driver.findElementByAndroidUIAutomator("text(\"Female\")").click();
		 pg.clkGender.click();
	//	 driver.findElementByAndroidUIAutomator("text(\"Let's  Shop\")").click();
		 pg.btnClick.click();
	//	int size= driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		int size=pg.listProduct.size();
	for(int i=0;i<size;i++)
	{
		//driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
	pg.listProduct.get(i).click();	
	}
	//driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		pg.btnCart.click();
	Thread.sleep(100);
	//int CartSize= driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
	int CartSize=pg.listCartPtoduct.size();
	float sum=0;
	for(int i=0;i<CartSize;i++)
	{
	//String Str=	driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
		String Str=pg.listCartPtoduct.get(i).getText();
	float amount=  getAmount(Str);
	sum=sum+amount;
		
		}
	System.out.println(sum);
	
	
	TouchAction t=new TouchAction(driver);	
	
	WebElement People_name=pg.lgpressperson;
	
t.longPress(longPressOptions().withElement(element(People_name)).withDuration(Duration.ofSeconds(5))).release().perform();
	
//ui.LongPress(People_name);
	System.out.println("Method LongProess Run");
//driver.findElementByAndroidUIAutomator("text(\"CLOSE\")").click();
	
pg.btnClose.click();

	}
	
	public static float getAmount(String str)
	{
		
		String str1=str.substring(1);
		float i=Float.parseFloat(str1);		
		return i;	
		
	}
	
	
	
}	