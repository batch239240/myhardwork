package stevejobs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test54
{
	public static void main(String[] args)
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
                "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		//explicit wait to maximize
		FluentWait w=new FluentWait(driver);
		w.withTimeout(100,TimeUnit.SECONDS);
		w.pollingEvery(2,TimeUnit.SECONDS);
		w.until(ExpectedConditions.visibilityOfElementLocated(
	                 By.className("rcMainTable")));
		driver.manage().window().maximize();
		driver.close();
	}
}
