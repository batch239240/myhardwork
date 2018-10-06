package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test33
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(
		  "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
				                           TimeUnit.SECONDS);
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		WebElement e=driver.findElement(By.name("cars"));
		Select s=new Select(e);
		if(s.isMultiple())
		{
			Actions a=new Actions(driver);
			if(System.getProperty("os.name").contains("Mac"))
			{
				a.keyDown(Keys.META).build().perform();
				Thread.sleep(5000);
			  a.click(s.getOptions().get(2)).build().perform();
				Thread.sleep(5000);
			  a.click(s.getOptions().get(0)).build().perform();
				a.keyUp(Keys.META).build().perform();
			}
			else  //for windows or linux or others
			{
				a.keyDown(Keys.CONTROL).build().perform();
				Thread.sleep(5000);
			  a.click(s.getOptions().get(2)).build().perform();
				Thread.sleep(5000);
			  a.click(s.getOptions().get(0)).build().perform();
				a.keyUp(Keys.CONTROL).build().perform();
			}
		}
		else
		{
			System.out.println("Single select");
		}
		//Back to page
		driver.switchTo().defaultContent();
		Thread.sleep(5000);
		//Close site
		driver.close();
	}
}
