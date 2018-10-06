package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test6
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch site using firefox browser
		System.setProperty("webdriver.gecko.driver",
				           "E:\\batch240\\geckodriver.exe");
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("http://newtours.demoaut.com");
		Thread.sleep(5000);
		//Click on register link
		driver.findElement(By.linkText("REGISTER")).click();
		Thread.sleep(5000);
		//Fill fields
		driver.findElement(By.name("firstName"))
		                                    .sendKeys("abdul");
		driver.findElement(By.name("lastName"))
		                                    .sendKeys("kalam");
		driver.findElement(By.name("phone"))
									.sendKeys("900066441244");
		driver.findElement(By.name("userName"))
		                       .sendKeys("apj@abdulkalam.com");
		driver.findElement(By.name("address1"))
		                            .sendKeys("Mosque street");
		driver.findElement(By.name("address2"))
		                         .sendKeys("Dhanushkoti road");
		driver.findElement(By.name("city"))
		                              .sendKeys("Rameshwaram");
		driver.findElement(By.name("state"))
		                                .sendKeys("Tamilnadu");
		driver.findElement(By.name("postalCode"))
		                                   .sendKeys("600072");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email"))
		                              .sendKeys("apjbatch240");
		driver.findElement(By.name("password"))
		                         .sendKeys("batch240sleepers");
		driver.findElement(By.name("confirmPassword"))
		                         .sendKeys("batch240sleepers");
		driver.findElement(By.name("register")).click();
		Thread.sleep(5000);
		//close site
		driver.close();
		
		
		
		
		

	}

}







