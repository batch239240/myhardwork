package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test51
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(
			   "https://semantic-ui.com/modules/dropdown.html"); 
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Scroll to bottom
		driver.executeScript(
			 "window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(5000);
		//scroll to top
		driver.executeScript(
			"window.scrollTo(document.body.scrollHeight,0);");
		Thread.sleep(5000);
		//scroll to specific element
		WebElement e=driver.findElement(By.xpath(
				"(//*[text()='Multiple Selection'])[2]"));
		driver.executeScript(
				"arguments[0].scrollIntoView();",e);
		
	}
}




