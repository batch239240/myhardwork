package stevejobs;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test77
{
	public static void main(String[] args) throws Exception 
	{
		//Provide device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("locationServicesEnabled",true);
		dc.setCapability("locationServicesAuthorized",true);
		dc.setCapability("appPackage",
				            "com.google.android.apps.maps");
		dc.setCapability("appActivity",
				     "com.google.android.maps.MapsActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch app in device
		AndroidDriver driver;
		while(2>1) //infinite loop
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break; //terminate from loop
			}
			catch(Exception e)
			{	
			}
		}
		//Goto home
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(10000);
		//get appium server address
		String x=driver.getRemoteAddress().getPath();
		System.out.println(x);
		String y=driver.getRemoteAddress().getProtocol();
		System.out.println(y);
		int z=driver.getRemoteAddress().getPort();
		System.out.println(z);
		String h=driver.getRemoteAddress().getHost();
		System.out.println(h);
		long l=driver.getDisplayDensity();
		System.out.println(l);
		String t=driver.getDeviceTime();
		System.out.println(t);
		String p=driver.getPlatformName();
		System.out.println(p);
		Thread.sleep(10000);
		//Get version of Android in device
		driver.openNotifications();
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
			  By.xpath("//*[@content-desc='Open settings.']")));
		driver.findElement(By.xpath(
						"//*[@content-desc='Open settings.']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				  By.xpath("//*[@text='About phone']")));
		driver.findElement(By.xpath("//*[@text='About phone']"))
													.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(
				  By.xpath("//*[@text='Software information']")));
		driver.findElement(By.xpath(
			   "//*[@text='Software information']")).click();
		Thread.sleep(10000);
		String v=driver.findElement(By.xpath(
		  "//*[@bounds='[48,216][131,252]']")).getAttribute("text");
		System.out.println(v);
		driver.pressKeyCode(AndroidKeyCode.HOME);
		Thread.sleep(10000);
		driver.launchApp();
		driver.closeApp();
		//Stop Appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");	
	}
}




