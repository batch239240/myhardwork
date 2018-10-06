package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test47
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
		/*
		//way-1
		driver.executeScript("document.getElementsByName('q')[0].style.border='2px blue solid';");
		//way-2
		WebElement e=driver.findElement(By.name("q"));
		driver.executeScript("arguments[0].style.border='2px blue solid';",e);
		//way-3
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("document.getElementsByName('q')[0].style.border='2px blue solid';");*/
		//way-4
		WebElement e=driver.findElement(By.name("q"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px blue solid';",e);
		
	}

}






