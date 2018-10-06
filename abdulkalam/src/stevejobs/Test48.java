package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Test48 
{
	public static void main(String[] args) throws InterruptedException
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
		driver.executeScript("document.getElementsByName('q')[0].setAttribute('disabled',true);");
		Thread.sleep(10000);
		driver.executeScript("document.getElementsByName('q')[0].removeAttribute('disabled');");	
	}
}





