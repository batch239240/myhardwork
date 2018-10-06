package stevejobs;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test24
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
		//Collect all images
		List<WebElement> l=driver.findElements(
											By.tagName("img"));
		System.out.println("Count of images is "+ l.size());
		int vi=0;
		int hi=0;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).isDisplayed())
			{
				vi=vi+1;
			}
			else
			{
				hi=hi+1;
			}
		}
		System.out.println("Visible images count is "+vi);
		System.out.println("Hidden images count is "+hi);
		//close site
		driver.close();

	}

}




