package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test53
{
	public static void main(String[] args) 
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		                     "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		//explicit wait to maximize
		WebDriverWait w=new WebDriverWait(driver,100);
		w.until(ExpectedConditions.visibilityOfElementLocated(
				                 By.className("rcMainTable")));
		driver.manage().window().maximize();
		//implicit wait(work for locate elements only)
		driver.manage().timeouts().implicitlyWait(20,
				                             TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='4']")).click();
		//explicit wait to close site
		w.until(ExpectedConditions.invisibilityOfElementLocated(
				                        By.className("raDiv")));
		driver.close();
	}
}





