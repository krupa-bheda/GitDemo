package Practies.AppiumFramework;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import net.bytebuddy.asm.Advice.Return;

public class ShoppingAppCap {
	
	public static AppiumDriverLocalService services;
	public static AndroidDriver<AndroidElement> driver;
	@BeforeTest
	public void Execute() throws IOException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
	}
	
	public AppiumDriverLocalService startServer()
	{
		//boolean flag=checkIfServerIsRunning(4723);
		//if(flag)
		//{
		services = AppiumDriverLocalService.buildDefaultService();
		services.start();
		//}
		
		return services;
	}
	public static void executeCmd() throws InterruptedException {
	    String anyCommand="appium";
	    boolean flag=checkIfServerIsRunning(4723);
	    if(flag==false)
	    {
	    try {
	        Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + anyCommand);
	        Thread.sleep(100);

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	    
	    }
	    else
	    {
	    	System.out.println("not running");
	    }
	    
	}

	public static  AndroidDriver<AndroidElement> Capability(String AppName) throws IOException, InterruptedException 
	{
		;
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Practies\\AppiumFramework\\global.properties");
	//	C:\\Users\\91809\\Documents\\Appium\\AppiumFramework
		Properties pro=new Properties();
		pro.load(fis);
		// TODO Auto-generated method stub	
		startEmulator();
		File fs=new File("src");
		File fs1=new File (fs,(String) pro.get(AppName));
        DesiredCapabilities cap=new DesiredCapabilities();
        String device=(String) pro.get("Device");
        //String deviceName=System.getProperty("deviceName");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,device);
		cap.setCapability(MobileCapabilityType.APP, fs1.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	    return driver;
		}
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning =false;
		ServerSocket serverSocket;
		try
		{
			serverSocket= new ServerSocket(port);
			serverSocket.close();
		}
		catch (IOException e) {
			// TODO: handle exception
			isServerRunning=true;
		}
		finally {
			serverSocket =null;
			
		}
		return isServerRunning;
		}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\Resouces\\startEmulator.bat");
     Thread.sleep(10000);
	}
	
	public static void  getScreenShots(String s) throws IOException
	{
   File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
   FileUtils.copyFile(file,new File(System.getProperty("user.dir")+"\\"+s+".png"));
	}
	
}
	

