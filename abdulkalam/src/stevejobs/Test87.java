package stevejobs;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test87
{
	public static void main(String[] args) throws Exception
	{
		//Provide device and app details
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","4200e6519aac84b9");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","7.1.1");
		dc.setCapability("automationName","uiautomator2");
		dc.setCapability("appPackage","com.whatsapp");
		dc.setCapability("appActivity","com.whatsapp.Main");
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
		//Automate app screen elements
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,20);
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(
				By.xpath("//*[@text='AGREE AND CONTINUE']")));
			driver.findElement(By.xpath(
			        "//*[@text='AGREE AND CONTINUE']")).click();
			wait.until(ExpectedConditions
				.visibilityOfElementLocated(
				By.xpath("//*[@text='CONTINUE']")));
			driver.findElement(By.xpath("//*[@text='CONTINUE']")).click();
			wait.until(ExpectedConditions
				.visibilityOfElementLocated(
				By.xpath("//*[@text='ALLOW']")));
			driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
			wait.until(ExpectedConditions
				.visibilityOfElementLocated(
				By.xpath("//*[@text='ALLOW']")));
			driver.findElement(By.xpath("//*[@text='ALLOW']")).click();
			wait.until(ExpectedConditions
				.visibilityOfElementLocated(
				By.xpath("//*[@text='phone number']")));
			driver.findElement(By.xpath("//*[@text='phone number']"))
			                            .sendKeys("9090909090");
			wait.until(ExpectedConditions
				.visibilityOfElementLocated(
				By.xpath("//*[@text='NEXT']")));
			driver.findElement(By.xpath("//*[@text='NEXT']")).click();
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
