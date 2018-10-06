package stevejobs;
import java.net.URL;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
public class Test76
{
	public static void main(String[] args) throws Exception
	{
		//Details of AVD and app 
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
		//Create driver object
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
		//send app to background for some time
		Duration d=Duration.of(10,ChronoUnit.SECONDS);
		driver.runAppInBackground(d);
		//Operate an element in app screen
		driver.findElement(By.xpath("//*[@text='9']")).click();
		//Reset app
		driver.resetApp();
		//get app package and activity names
		String x=driver.getCurrentPackage();
		String y=driver.currentActivity();
		System.out.println(x);
		System.out.println(y);
		//Try to install other app and validate installation
		try
		{
			driver.installApp("C:\\Users\\Mindq-pc\\com.whatsapp-2.apk");
			Thread.sleep(20000);
			if(driver.isAppInstalled("com.whatsapp"))
			{
				Activity a=new Activity("com.whatsapp","com.whatsapp.Main");
				driver.startActivity(a);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//Back to initial app and close
		driver.launchApp();
		driver.closeApp();
		//Stop appium server
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
