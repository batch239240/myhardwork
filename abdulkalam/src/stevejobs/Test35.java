package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test35
{
	public static void main(String[] args) 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                  TimeUnit.SECONDS);
		//Right click on an element
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.name("q"));           
		a.contextClick(e).build().perform();
	}
}








