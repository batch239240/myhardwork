package stevejobs;
import java.net.URL;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidDriver;
public class Test71 
{
	public static void main(String[] args) throws Exception
	{
		//Take data from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter contact name in lower case");
		String x=sc.nextLine();
		System.out.println("Enter contact pos in results");
		int y=sc.nextInt();
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
			driver.findElement(By.xpath(
						 "//*[@text='CONTACTS']")).click();
			w.until(ExpectedConditions.
					visibilityOfElementLocated(
				By.xpath("//*[contains(@text,'Search')]")));
			driver.findElement(By.xpath(
					"//*[contains(@text,'Search')]"))
			                             .sendKeys(x);
			w.until(ExpectedConditions.
					visibilityOfElementLocated(By.xpath(
			"//*[@text='No results found' or @text='CONTACTS']")
							                                 ));
			try
			{
				if(driver.findElement(By.xpath(
						"//*[@text='No results found']"))
						.isDisplayed())
				{
					System.out.println("No contacts to call");
				}
			}
			catch(Exception exe)
			{
				driver.findElement(By.xpath(
		           "//*[@class='android.view.ViewGroup'][@index='"+y+"']")).click();
				w.until(ExpectedConditions.
						visibilityOfElementLocated(By.xpath(
		   "//*[contains(@resource-id,'expand_call_sim2')]")));
				driver.findElement(By.xpath(
			"//*[contains(@resource-id,'expand_call_sim2')]"))
				                                     .click();
				Thread.sleep(10000);
				//Handle dynamic screen elements using Android
				try
				{
					if(driver.findElementByAndroidUIAutomator(
						"new UiSelector().text(\"Dialling\")")
							.isDisplayed())
					{
						driver.findElementByAndroidUIAutomator(
					"new UiSelector().description(\"End call\")")
						                                .click();
					}
				}
				catch(Exception exec)
				{
					driver.findElementByAndroidUIAutomator(
					"new UiSelector().description(\"End call\")")
					                                    .click();
					w.until(ExpectedConditions.
							visibilityOfElementLocated(By.xpath(
					  "//*[contains(@resource-id,'message')]")));
					String m=driver.findElement(By.xpath(
						"//*[contains(@resource-id,'message')]"))
								            .getAttribute("text");
					System.out.println(m);
					driver.findElement(By.xpath(
							 "//*[@text='OK']")).click();	
				}
			}
			//Close app
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





