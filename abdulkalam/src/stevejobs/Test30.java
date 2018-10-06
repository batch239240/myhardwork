package stevejobs;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test30
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,
				                            TimeUnit.SECONDS);
		//Do login
		driver.findElement(By.name("identifier"))
		                            .sendKeys("xxxxxxxx");
		driver.findElement(By.xpath("//*[text()='Next']"))
													.click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                               .sendKeys("xxxxxxxx");
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                            .click();
		Thread.sleep(5000);
		//Goto 7th mail in mail box table & select check-box
		driver.findElement(By.xpath(
				"(//table)[6]/tbody/tr[7]/td[2]/div")).click();
		Thread.sleep(5000);
		//Delete mail
		driver.findElement(By.xpath(
		  "//*[@gh='mtb']/div/div/child::div[2]/child::div[3]"))
													.click();
		Thread.sleep(5000);
		//Do logout
		driver.findElement(By.xpath(
				"//*[contains(@title,'Google Account')]/span"))
						                              .click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Sign out")).click();
		Thread.sleep(5000);
		//Close site
		driver.close();

	}

}
