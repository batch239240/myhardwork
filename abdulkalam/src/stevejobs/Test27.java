package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test27
{
	public static void main(String[] args) throws InterruptedException 
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
		                            .sendKeys("gopirowthu9");
		driver.findElement(By.xpath("//*[text()='Next']"))
													.click();
		Thread.sleep(5000);
		driver.findElement(By.name("password"))
		                               .sendKeys("9000228418");
		driver.findElement(By.xpath("//*[text()='Next']"))
		                                            .click();
		Thread.sleep(5000);
		//Get count of mails in mail box table
		List<WebElement> l1=driver.findElements(By.xpath(
				                    "(//table)[6]/tbody/tr"));
		System.out.println("Count of mails is "+l1.size());
		List<WebElement> l2=driver.findElements(By.xpath(
                "(//table)[6]/tbody/tr[3]/td"));
		System.out.println("Count of cols is "+l2.size());
		for(int i=0;i<l2.size();i++)
		{
			String x=l2.get(i).getAttribute("value");
			System.out.println(x);
		}
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





