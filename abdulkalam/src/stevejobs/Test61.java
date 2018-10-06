package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test61
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", 
				"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input.inputtext")).sendKeys("rgdhf");
		driver.findElement(By.cssSelector("input[name=pass]")).sendKeys("gsg");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@value='Log In']")).click();
		

	}

}




