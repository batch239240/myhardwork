package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test14
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//Get details 
		String x=driver.findElement(By.name("q")).getAttribute("role");
		System.out.println(x);
		String y=driver.findElement(By.xpath("(//*[@class='Fx4vi'])[6]")).getText();
		System.out.println(y);
		//fill element
		driver.findElement(By.name("q")).sendKeys("kalam");
		Thread.sleep(5000);
		//Get details
		String z=driver.findElement(By.xpath("(//*[@class='sbqs_c'])[1]")).getText();
		System.out.println(z);
		//Close site
		driver.close();
				

	}

}
