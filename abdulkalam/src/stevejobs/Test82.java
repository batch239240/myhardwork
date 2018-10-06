package stevejobs;

import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Test82
{
	public static void main(String[] args) throws Exception
	{
		//Details of AVD and app
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME,"");
		dc.setCapability("deviceName","emulator-5554");
		dc.setCapability("platformName","android");
		dc.setCapability("platformVersion","4.2.2");
		dc.setCapability("appPackage","com.android.calendar");
		dc.setCapability("appActivity",
				 "com.android.calendar.AllInOneActivity");
		//Start appium server
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		//Create driver object to launch app in AVD
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
		//Automate app screens
		try
		{
			//Swipe on app screen
			int w=driver.manage().window().getSize().getWidth();
		  	int h=driver.manage().window().getSize().getHeight();
			TouchAction ta=new TouchAction(driver);
			//swipe from right to left 5 times
			int x1=(int)(w*0.9);//near to right edge
			int y1=(int)(h/2);
			int x2=(int)(w*0.7); //near to center or left edge
			int y2=(int)(h/2);
			for(int i=1;i<=5;i++)
			{
			    Duration d=Duration.of(5,ChronoUnit.SECONDS);
			    ta.press(x1,y1).moveTo(x2,y2).waitAction(d)
			                                .release().perform();
			}
			//swipe from left to right 5 times
			x1=(int)(w*0.3);//near to left edge
			x2=(int)(w*0.6); //near to center or right edge
			for(int i=1;i<=5;i++)
			{
				Duration d=Duration.of(5,ChronoUnit.SECONDS);
				ta.press(x1,y1).moveTo(x2,y2).waitAction(d)
				                           .release().perform();
			}
			//Close app
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
