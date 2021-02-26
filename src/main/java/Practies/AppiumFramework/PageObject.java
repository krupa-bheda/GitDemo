package Practies.AppiumFramework;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageObject {

	public PageObject(AndroidDriver<AndroidElement> driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	//driver.findElementByAndroidUIAutomator("text(\"Afghanistan\")").click();
	
	@AndroidFindBy  (uiAutomator= "new UiSelector().text(\"Afghanistan\")")
	public WebElement sel;
	
	@AndroidFindBy  (uiAutomator= "new UiSelector().text(\"Antarctica\")")
	public WebElement clkAntarctica;
	
	@AndroidFindBy  (uiAutomator= "new UiSelector().text(\"Enter name here\")")
	public WebElement inputName;
	@AndroidFindBy  (uiAutomator= "new UiSelector().text(\"Female\")")
	public WebElement clkGender;
	@AndroidFindBy  (uiAutomator= "new UiSelector().text(\"Let's  Shop\")")
	public WebElement btnClick;
	
	@AndroidFindBy  (id= "com.androidsample.generalstore:id/productAddCart")
	public java.util.List<WebElement>  listProduct;
	
	@AndroidFindBy  (id= "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement  btnCart;
	
	@AndroidFindBy  (id= "com.androidsample.generalstore:id/productPrice")
	public java.util.List<WebElement>  listCartPtoduct;
	
	@AndroidFindBy  (uiAutomator= "new UiSelector().text(\"Please read our terms of conditions\")")
	public WebElement lgpressperson;
	
	@AndroidFindBy  (id= "android:id/button1")
	public WebElement btnClose;
}


