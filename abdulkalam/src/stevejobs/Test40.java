package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test40
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/slider/"); 
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                  TimeUnit.SECONDS);
		//Automate Horizontal slider
		driver.switchTo().frame(0);
		Actions a=new Actions(driver);
		WebElement e1=driver.findElement(By.xpath(
				"//*[contains(@class,'ui-slider-handle')]"));
		//slider from left to right
		a.dragAndDropBy(e1,150,0).build().perform(); 
		Thread.sleep(5000);
		a.dragAndDropBy(e1,-150,0).build().perform();
		//Back to page
		driver.switchTo().defaultContent();
		//Click on Vertical slider
		driver.findElement(By.linkText("Vertical slider"))
		                                              .click();
		Thread.sleep(5000);
		//Automate Vertical slider
		driver.switchTo().frame(0);
		WebElement e2=driver.findElement(By.xpath(
				"//*[contains(@class,'ui-slider-handle')]"));
		a.dragAndDropBy(e2,0,50).build().perform();
		Thread.sleep(5000);
		a.dragAndDropBy(e2,0,-150).build().perform();
		//Back to page
		driver.switchTo().defaultContent();
		//close site
		driver.close();		
	}
}
