package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test41 {

	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get(
			  "https://semantic-ui.com/modules/dropdown.html"); 
		Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                    TimeUnit.SECONDS);
		//Open drop-down(mandatory)
		Actions a=new Actions(driver);
		WebElement e=driver.findElement(By.xpath(
				            "(//*[@class='ui dropdown'])[1]"));
		a.click(e).build().perform();
		Thread.sleep(5000);
		//Get all items
		List<WebElement> il=driver.findElements(By.xpath(
				"//*[@class='menu transition visible']/div"));
		System.out.println(il.size());
		for(int i=0;i<il.size();i++)
		{
			System.out.println(il.get(i).getText());
		}
		Thread.sleep(5000);
		//select 4th item in that single select drop-down
		driver.findElement(By.xpath(
			"//*[@class='menu transition visible']/div[4]"))
		                                            .click();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
