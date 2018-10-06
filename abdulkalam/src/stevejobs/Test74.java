package stevejobs;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test74
{
	public static void main(String[] args) throws Exception
	{
		//Details of AVD and calc app 
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage",
					     "com.android.calculator2");
		dc.setCapability("appActivity",
				         "com.android.calculator2.Calculator");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object and launch app
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
		//wait for app launching completely
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                 By.xpath("//*[@text='9']")));
		//rotate screen
		String x=driver.getOrientation().name();
		if(x.equalsIgnoreCase("portrait"))
		{
			driver.rotate(ScreenOrientation.LANDSCAPE);
			Thread.sleep(10000);
			driver.rotate(ScreenOrientation.PORTRAIT);
		}
		Thread.sleep(10000);
		driver.lockDevice();
		Thread.sleep(10000);
		if(driver.isLocked())
		{
			System.out.println("Locked");
			driver.unlockDevice();
		}
		Thread.sleep(10000);
		//close app
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
