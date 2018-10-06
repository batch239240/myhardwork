package stevejobs;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Button;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class Test89
{
	public static void main(String[] args) throws Exception
	{
		//Get Environment
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter platform as computer/mobile");
		String p=sc.nextLine();
		if(p.equalsIgnoreCase("computer"))
		{
			//selenium webdriver with sikulix
			System.setProperty("webdriver.chrome.driver",
			           "E:\\batch237\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://www.youtube.com");
			Thread.sleep(5000);
			//Search video link(SWD)
			driver.findElement(By.name("search_query"))
			          .sendKeys("kalam sir speech",Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.partialLinkText(
				"Dr. A P J Abdul Kalam in European")).click();
			Thread.sleep(10000);//time to start & get skipadd
			//Automate video icons using sikulix
			Screen s=new Screen();
			if(s.exists("skipadd.png")!=null)
			{
				s.click("skipadd.png");
			}
			Thread.sleep(5000);
			//Move mouse pointer to video body to get icons
			Location l=new Location(300,200);
			s.wheel(l,Button.LEFT,0);
			//Click pause icon
			s.click("pause.png");
			Thread.sleep(5000);
			//Move mouse pointer to video body to get icons
			s.wheel(l,Button.LEFT,0);
			//Click play icon
			s.click("play.png");
			Thread.sleep(10000);
			//Close site
			driver.close();
		}
		else
		{
			//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Details of ARD with browser
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,
					                               "chrome");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","7.1.1");
			//Create driver object to launch chrome browser
			IOSDriver driver;
			while(2>1)
			{
				try
				{
					driver=new IOSDriver(u,dc);
					break; //terminate from loop
				}
				catch(Exception ex)
				{
				}	
			}
			//Launch site
			driver.get("http://www.youtube.com");
			//Change context from site(WEB_VIEW) to app(NATIVE_APP)
			driver.context("NATIVE_APP"); 
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath(
					"//*[@text='Search YouTube'][@index='2']")));
			TouchAction ta=new TouchAction(driver);
			ta.tap(580,210).perform(); //tap on Search YouTube
			driver.findElement(By.xpath(
			  "//*[@class='android.widget.EditText'][@index='0']"))
							.sendKeys("kalam sir speech");
			w.until(ExpectedConditions.visibilityOfElementLocated(
					 By.xpath(
					"//*[@text='Search YouTube']")));
			driver.findElement(By.xpath(
					"//*[@text='Search YouTube']")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(
					   By.xpath(
			   "//*[contains(@text,'Abdul Kalam in European')]")));
			//Start video
			driver.findElement(By.xpath(
			 "//*[contains(@text,'Abdul Kalam in European')]"))
													.click();
			//Close site as app
			driver.closeApp();
			//stop appium server
			Runtime.getRuntime().exec("taskkill /F /IM node.exe");
			Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}

	}

}
