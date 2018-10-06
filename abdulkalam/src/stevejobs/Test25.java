package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test25
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
		List<WebElement> l=driver.findElements(By.tagName("input"));
		int tbc=0;
		for(int i=0;i<l.size();i++)
		{
			String x=l.get(i).getAttribute("type");
			if(x.equals("text"))
			{
				tbc=tbc+1;
			}
		}
		System.out.println("Count of text boxes is "+tbc);
		driver.close();
	}

}




