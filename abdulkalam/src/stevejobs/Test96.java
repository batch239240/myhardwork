package stevejobs;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class Test96 
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
			driver.pressKeyCode(AndroidKeyCode.HOME);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@resource-id,'iconview_imageView')]")));
			driver.findElement(By.xpath("//*[contains(@resource-id,'iconview_imageView')]")).click();
			wait.until(ExpectedConditions.
					visibilityOfElementLocated(By.xpath(
				"//*[contains(@content-desc,'My Galaxy')]")));
			driver.findElement(By.xpath("//*[contains(@content-desc,'My Galaxy')]")).click();
			wait.until(ExpectedConditions.
					visibilityOfElementLocated(By.xpath(
							"//*[@text='MUSIC']")));
			driver.pressKeyCode(AndroidKeyCode.BACK);
			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("toastedmsgss.png");
			FileUtils.copyFile(src,dest);
			driver.launchApp();
			driver.closeApp();
			//Load inbuilt "tessdata" folder, which have characters
			File fo=LoadLibs.extractTessResources("tessdata");  
			//Create object to apply OCR on image
			Tesseract obj=new Tesseract();
			obj.setDatapath(fo.getAbsolutePath());
			//Take screenshot file, which have text in content
			File f=new File("toastedmsgss.png"); 
			String result=obj.doOCR(f);
			Thread.sleep(20000);
			System.out.println(result);
			if(result.contains("Press 'Back' again to exit"))
			{
				System.out.println("Test passed");
			}
			else
			{
				System.out.println("Test failed");
			}
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
