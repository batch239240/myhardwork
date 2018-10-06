package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test15
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
		String x=driver.findElement(By.name("q")).getCssValue("height");
		System.out.println(x);
		//close site
		driver.close();

	}

}
