package stevejobs;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test85
{
	public static void main(String[] args) throws Exception
	{
		//Details of ARD and vodQA app 
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage",
				  "com.vodqareactnative");
		dc.setCapability("appActivity",
				"com.vodqareactnative.MainActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch phone app
		AndroidDriver driver;
		while(2>1) //infinite loop
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
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(
					By.xpath("//*[@text='LOG IN']")));
			driver.findElement(By.xpath("//*[@text='LOG IN']"))
			                                    .click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(
					By.xpath("//*[@text='Double Tap']")));
			driver.findElement(By.xpath(
					     "//*[@text='Double Tap']")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(
					By.xpath("//*[@text='Double Tap Me']")));
			WebElement e=driver.findElement(By.xpath(
					           "//*[@text='Double Tap Me']"));
			//Double tap
			TouchAction action1=new TouchAction(driver);
			action1.tap(e);
			TouchAction action2=new TouchAction(driver);
			action2.waitAction(Duration.ofMillis(100)).tap(e);
			MultiTouchAction ma=new MultiTouchAction(driver);
			ma.add(action1).add(action2).perform();
			try
			{
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(
						By.xpath("//*[@text='Double tap successful!']")));
				System.out.println("operation was finished");
			}
			catch(Exception ex)
			{
			    System.out.println("operation was not finished");
			}
			//close app
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
