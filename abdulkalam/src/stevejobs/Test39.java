package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test39
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                  TimeUnit.SECONDS);
		//Automate drag and drop
		driver.switchTo().frame(0);
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		Thread.sleep(5000);
		a.dragAndDrop(e1,e2).build().perform();
		//Back to page
		driver.switchTo().defaultContent();
		//Close site
		driver.close();
		
		
		
		

	}

}
