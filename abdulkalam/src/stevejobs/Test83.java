package stevejobs;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class Test83
{
	public static void main(String[] args) throws Exception
	{
		//Details of ARD and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage",
				         "com.samsung.android.contacts");
		dc.setCapability("appActivity",
				 "com.android.dialer.DialtactsActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch app in ARD
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break; //terminate from loop
			}
			catch(Exception ex)
			{
			}	
		}
		//Automation
		try
		{
			WebDriverWait w=new WebDriverWait(driver,100);
			w.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(
							"//*[@text='CONTACTS']")));
			//Back to home
			driver.pressKeyCode(AndroidKeyCode.HOME);
			w.until(ExpectedConditions.
					visibilityOfElementLocated(By.xpath(
					"//*[contains(@content-desc,'WhatsApp')]")));
			//Long press on "WhatsApp" icon to remove shortcut
			MobileElement e=(MobileElement) driver.findElement(
			    By.xpath("//*[contains(@content-desc,'WhatsApp')]"));
			TouchAction ta=new TouchAction(driver);
			Duration d=Duration.of(10,ChronoUnit.SECONDS);
			ta.longPress(e).waitAction(d).release().perform();
			//Click on Remove shortcut in menu 
			driver.findElementByAndroidUIAutomator(
				"new UiSelector().textContains(\"shortcut\")")
			                                          .click();
			//close app
			driver.launchApp();
			driver.closeApp();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");

	}

}
