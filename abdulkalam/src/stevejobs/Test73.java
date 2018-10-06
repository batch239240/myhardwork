package stevejobs;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
public class Test73
{
	public static void main(String[] args) throws Exception
	{
		//Provide details of ARD and app
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
		//Create object to AndroidDriver to launch app
		AndroidDriver driver;
		while(2>1)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex)
			{
			}
		}
		//Automation
		try
		{
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.
				 visibilityOfElementLocated(By.xpath(
						 "//*[@text='CONTACTS']")));
		//Back to home
		driver.pressKeyCode(AndroidKeyCode.HOME);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'iconview_imageView')]")));
		//Go to apps list
		driver.findElement(By.xpath("//*[contains(@resource-id,'iconview_imageView')]")).click();
		//open Cricbuzz app
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@content-desc='Cricbuzz']")));
		driver.findElement(By.xpath("//*[@content-desc='Cricbuzz']")).click();
		
		//Back to initial app
		driver.launchApp();
		//close app
		driver.closeApp();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
