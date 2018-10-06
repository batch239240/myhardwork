package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test10
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch website
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Fill mobile number
		driver.findElement(By.name("username")).sendKeys("9090909090",Keys.chord(Keys.ALT,"c"));
		Thread.sleep(5000);
		driver.findElement(By.name("username")).clear();
	}
}
