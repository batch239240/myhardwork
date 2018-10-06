package stevejobs;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test17 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Click on element
		driver.findElement(By.xpath(
			   "//*[contains(@src,'android-button')]")).click();
		Thread.sleep(5000);
		//Get window handles
		ArrayList<String> x=new ArrayList<String>(
				                    driver.getWindowHandles());
		//Switch to 2nd tab
		driver.switchTo().window(x.get(1));
		driver.close();
		//Switch to 1st tab
		driver.switchTo().window(x.get(0)); 
		
		
		
		

	}

}
