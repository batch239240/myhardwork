package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test18
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
				"E:\\batch240\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.way2sms.com/content/index.html");
		Thread.sleep(5000);
		//Enter password and click sign-in
		driver.switchTo().activeElement().sendKeys("mindq");
		driver.findElement(By.id("loginBTN")).click();
		Thread.sleep(5000);
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().dismiss();
		//close site
		driver.close();
	}

}





