package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test20
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.xpath(
					"//*[@name='hiddenPassword']"))
					.isDisplayed())
			{
				System.out.println("visible in page");
				
			}
			else
			{
				System.out.println("Not visible in page");
			}
		}
		catch(Exception e)
		{
			System.out.println("No element in source code");
		}
		driver.close();
	}

}
