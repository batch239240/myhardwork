package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test21
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.goindigo.in");                   
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//validate a radio button
		try
		{
			WebElement e=driver.findElement(By.xpath(
				"(//*[@id='oneway-trip-armForce'])[2]/following-sibling::*[1]"));
			if(e.isDisplayed())
			{
				if(e.isEnabled())
				{
					if(e.isSelected())
					{
						System.out.println("Selected");
					}
					else
					{
						System.out.println("Not Selected");
					}
				}
				else
				{
					System.out.println("Not enabled");
				}
			}
			else
			{
				System.out.println("Not visible");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Wrong element");
		}
		//Close site
		driver.close();
	}
}
