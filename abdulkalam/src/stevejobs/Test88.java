package stevejobs;

import java.net.URL;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Test88
{
	public static void main(String[] args) throws Exception
	{
		//Give Environment(computer/mobile)
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter platform as computer/mobile");
		String p=sc.nextLine();
		WebDriver driver;
		if(p.equals("computer"))
		{
			System.setProperty("webdriver.chrome.driver",
			           "E:\\batch240\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			//Provide device details
			DesiredCapabilities dc=new DesiredCapabilities();
			dc.setCapability(CapabilityType.BROWSER_NAME,
					                               "chrome");
			dc.setCapability("deviceName","4200e6519aac84b9");
			dc.setCapability("platformName","android");
			dc.setCapability("platformVersion","7.1.1");
			//Start appium server
			Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
			URL u=new URL("http://0.0.0.0:4723/wd/hub");
			//Create driver object to launch chrome browser
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
		}
		//common automation code
		driver.get("http://newtours.demoaut.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                    By.linkText("REGISTER")));
		//Click on register link
		driver.findElement(By.linkText("REGISTER")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
		//Fill fields
		driver.findElement(By.name("firstName"))
		                                    .sendKeys("abdul");
		driver.findElement(By.name("lastName"))
		                                    .sendKeys("kalam");
		driver.findElement(By.name("phone"))
									.sendKeys("900066441244");
		driver.findElement(By.name("userName"))
		                       .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("address1"))
		                            .sendKeys("Mosque street");
		driver.findElement(By.name("address2"))
		                         .sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city"))
		                              .sendKeys("Rameshwaram");
		driver.findElement(By.name("state"))
		                                .sendKeys("Tamilnadu");
		driver.findElement(By.name("postalCode"))
		                                   .sendKeys("600072");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email"))
		                              .sendKeys("apjbatch240");
		driver.findElement(By.name("password"))
		                         .sendKeys("batch240sleepers");
		driver.findElement(By.name("confirmPassword"))
		                         .sendKeys("batch240sleepers");
		driver.findElement(By.name("register")).click();
		//close site
		driver.close();
		//close appium server for mobile based
		if(!p.equals("computer"))
		{
		 Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		 Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
		}
	}
}







