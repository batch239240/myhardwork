package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test26
{
	public static void main(String[] args) 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.goindigo.in"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(100,
				                            TimeUnit.SECONDS);
		//Collect all text boxes
		List<WebElement> l=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Count of text boxes is "+l.size());
		//Close site
		driver.close();
	}
}





