package stevejobs;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test38
{
	public static void main(String[] args) throws InterruptedException
	{
		//Enter inputs
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word to search");
		String x=sc.nextLine();
		System.out.println("Enter expected sugestion");
		String y=sc.nextLine();
		//Launch site
		System.setProperty("webdriver.chrome.driver",
		          "E:\\batch240\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.google.co.in"); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,
		                                  TimeUnit.SECONDS);    
		//Enter text into auto-complete element
		//to get suggestions
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		a.sendKeys(e,x).build().perform();
		Thread.sleep(5000);
		int c=0;
		while(2>1)   //infinite loop
		{
			a.sendKeys(Keys.DOWN).build().perform();
			c=c+1;
			String z=e.getAttribute("value");
			if(z.equals(y))
			{
				System.out.println("Item was found at "+c);
				a.sendKeys(Keys.ENTER).build().perform();
				break; //terminate from loop
			}
			if(c==10)
			{
				System.out.println("Sorry, item was not found");
				break; //terminate from loop
			}
		}
		//Close site
		driver.close();

	}

}




