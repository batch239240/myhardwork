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

public class Test86
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
				  "com.vodqareactnative");
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
					By.xpath("//*[@text='Photo View']")));
			driver.findElement(By.xpath(
					     "//*[@text='Photo View']")).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(
						"//*[@class='android.widget.ImageView']")));
			WebElement e=driver.findElement(By.xpath(
					     "//*[@class='android.widget.ImageView']"));
			int x=e.getLocation().getX();
			int y=e.getLocation().getY();
			int w=e.getSize().getWidth();
			int h=e.getSize().getHeight();
			//zoom out on element
			TouchAction ta1=new TouchAction(driver);
			ta1.press(272,707).waitAction(
				Duration.ofMillis(5000)).moveTo(172,707).release();
			TouchAction ta2=new TouchAction(driver);
			ta2.press(484,707).waitAction(
				Duration.ofMillis(5000)).moveTo(640,707)
													.release();
			MultiTouchAction ma=new MultiTouchAction(driver);
			ma.add(ta1).add(ta2).perform();
			Thread.sleep(20000);
			//close site
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
