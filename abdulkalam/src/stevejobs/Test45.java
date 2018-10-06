package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test45
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
		//way-1
		//driver.findElement(By.name("btnI")).click();
		//Way-2
		//WebElement e=driver.findElement(By.name("btnI"));
		//e.click();
		//way-3
		//WebElement e=driver.findElement(By.name("btnI"));
		//Actions a=new Actions(driver);
		//a.click(e).build().perform();
		//Way-4
		//driver.executeScript("document.getElementsByName('btnI')[0].click();");
		//way-5
		//WebElement e=driver.findElement(By.name("btnI"));
		//driver.executeScript("arguments[0].click();",e);
		//Way-6
		//JavascriptExecutor js=(JavascriptExecutor) driver;
		//js.executeScript("document.getElementsByName('btnI')[0].click();");
		//way-7
		WebElement e=driver.findElement(By.name("btnI"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",e);
		driver.close();
		

	}
}





