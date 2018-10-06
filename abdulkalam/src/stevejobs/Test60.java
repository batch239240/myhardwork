package stevejobs;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test60
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", 
						"E:\\batch237\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Get tool-tip via title attribute
		WebElement e1=driver.findElement(By.linkText("JAVASCRIPT"));
		String x=e1.getAttribute("title");
		System.out.println(x);
		Thread.sleep(5000);
		//Scroll page to specific element
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement e2=driver.findElement(By.xpath(
						     "//*[text()='Demo: Tooltip Examples']"));
		js.executeScript("arguments[0].scrollIntoView();",e2);
		Thread.sleep(5000);
		//Move mouse pointer to an element for tool-tip
		WebElement e3=driver.findElement(By.xpath(
						        "(//*[@class='tooltip'])[1]"));
		Actions a=new Actions(driver);
		a.moveToElement(e3).clickAndHold().build().perform();
		Thread.sleep(5000);
		WebElement e4=driver.findElement(By.xpath(
						   "(//*[@class='tooltip'])[1]/span"));
		String y=e4.getText();
		System.out.println(y);
		a.release().build().perform();
		//Close site
		driver.close(); 

	}

}
