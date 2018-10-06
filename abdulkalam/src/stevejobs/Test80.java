package stevejobs;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test80
{
	public static void main(String[] args) throws Exception
	{
		//Details of ARD and phone app 
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("appPackage","com.vodqareactnative");
		dc.setCapability("appActivity",
				        "com.vodqareactnative.MainActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch app
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
					By.xpath("//*[@text='Drag & Drop']")));
			driver.findElement(By.xpath(
					      "//*[@text='Drag & Drop']")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(
					By.xpath("//*[@text='Drag me!']")));
			WebElement e1=driver.findElement(By.xpath(
					               "//*[@text='Drag me!']"));
			WebElement e2=driver.findElement(By.xpath(
					               "//*[@text='Drop here.']"));
			TouchAction ta=new TouchAction(driver);
			Duration d=Duration.of(10,ChronoUnit.SECONDS);
			ta.press(e1).waitAction(d).moveTo(e2).release()
												.perform();
			try
			{
				if(driver.findElement(By.xpath(
					"//*[@text='Circle dropped']"))
						.isDisplayed())
				{
				 System.out.println("operation was finished");
				}
			}
			catch(Exception exc)
			{
				System.out.println(exc.getMessage());
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






